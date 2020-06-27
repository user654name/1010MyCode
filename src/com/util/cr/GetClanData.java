package com.util.cr;

import com.util.BeanUtil;
import com.util.DateUtil;
import com.util.MailUtil;
import com.util.NumberUtil;
import com.util.constant.CrEnum;
import com.util.model.Player;
import com.util.model.vo.ClanInfoVo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.Duration;
import java.util.*;

/**
 * @author Tianqi.Zhang
 * @date 2020/5/29
 * @time 23:19
 * @package com.util.cr
 * @project 1008MyDemo
 * @description
 */
public class GetClanData {


    private static final String LINT_BREAK_CODE = "\n";
    private static final String LINT_BREAK_HTML = "<br>";

    /**
     * Leader
     * Co-Leader
     * Elder
     * Member
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        StringBuilder mailContent = new StringBuilder();
        // https://royaleapi.com/clan/PCRQUPLG
        CrEnum.ClanTagEnum clan;

        clan = CrEnum.ClanTagEnum.图书罐;
        clan = CrEnum.ClanTagEnum.小鸣同学;
        clan = CrEnum.ClanTagEnum.诸事皆宜;
        clan = CrEnum.ClanTagEnum.白世家族;

        String clanTag = clan.getClanTag();


        String lineBreak = LINT_BREAK_HTML;

        mailContent.append("部落标签 : " + clanTag).append(lineBreak);
        mailContent.append("开始查询部落信息......").append(lineBreak);

        long start = System.currentTimeMillis();
        ClanInfoVo clanInfo = queryClanInfo(clanTag);

        List<Player> clanMembers = clanInfo.getClanMembers();

        long end = System.currentTimeMillis();
        mailContent.append("部落信息查询成功，耗时" + (end - start) + "毫秒").append(lineBreak);

        Map<String, List<Player>> roleMap = new HashMap<>(4);
        for (Player member : clanMembers) {
            String role = member.getRole();
            if (roleMap.containsKey(role)) {
                List<Player> players = roleMap.get(role);
                players.add(member);
            } else {
                List<Player> players = new ArrayList<>();
                players.add(member);
                roleMap.put(role, players);
            }
        }
        List<Player> coLeaders = roleMap.get("Co-Leader");
        List<Player> elders = roleMap.get("Elder");
        List<Player> members = roleMap.get("Member");


//        mailContent.append("赛季第").append("天").append("距离结算日");
        createRoleInfo("全部", mailContent, lineBreak, clanMembers);
        createRoleInfo("副首", mailContent, lineBreak, coLeaders);
        createRoleInfo("长老", mailContent, lineBreak, elders);
        createRoleInfo("成员", mailContent, lineBreak, members);

        if (CrEnum.ClanTagEnum.图书罐.getClanTag().equals(clanTag)) {
            int coLeaderThreshold = 600;
            int elderThreshold = 300;
            showCanUpgrade(mailContent, lineBreak, elders, coLeaderThreshold, CrEnum.ClanRoleEnum.Elder);
            showCanUpgrade(mailContent, lineBreak, members, elderThreshold, CrEnum.ClanRoleEnum.Member);
        }

        showWarn(mailContent, clanInfo.getClanMembers(), lineBreak);


        mailContent.append("数据读取时间 : ").append(DateUtil.getNowCn());


        System.out.println(mailContent.toString().replaceAll(LINT_BREAK_HTML, LINT_BREAK_CODE));
        String sendTo = "ztqztq@qq.com";
        String subject = "【" + clanInfo.getClanName() + "】部落情况";
        MailUtil.sendEmail(sendTo, subject, mailContent.toString());
    }

    private static void createRoleInfo(Object role, StringBuilder mailContent, String lineBreak, List<Player> players) throws Exception {
        mailContent.append(role).append(":");
        mailContent.append(players.size())
                .append(" 平均奖杯:")
                .append(getAvg(players, "trophies"))
                .append(" 捐卡:")
                .append(getAvg(players, "donate"))
                .append(" 求卡:")
                .append(getAvg(players, "received"))
                .append(lineBreak);
    }

    private static int getAvg(List<Player> players, String field) throws Exception {
        List<Integer> numberList = new ArrayList<>();
        for (Player player : players) {
            Integer number = Integer.valueOf((String) BeanUtil.getGetMethod(player, field));
            numberList.add(number);
        }

        ;
        return players.size() > 0 ? NumberUtil.avg(numberList) : 0;
    }


    /**
     * 超过两天不登录，超过7天不登录，10天
     *
     * @param mailContent
     * @param clanMembers
     * @param lineBreak
     */
    private static void showWarn(StringBuilder mailContent, List<Player> clanMembers, String lineBreak) {

        Map<String, List<String>> timeMap = new HashMap();
        timeMap.put("2to4", new ArrayList<>());
        timeMap.put("4to7", new ArrayList<>());
        timeMap.put("7", new ArrayList<>());
        mailContent.append("");
//        System.out.println(clanMembers.size());

        for (Player player : clanMembers) {
            Long l = player.getLastLogin().toDays();
            System.out.println(l);
            System.out.println(player);
            if (NumberUtil.between(l, 2L, 4L)) {
                List<String> list = timeMap.get("2to4");
                list.add(player.getNickName());
                timeMap.put("2to4", list);
                System.out.println("2to4" + player);
            } else if (NumberUtil.between(l, 4L, 7L)) {
                List<String> list = timeMap.get("4to7");
                list.add(player.getNickName());
                timeMap.put("4to7", list);
                System.out.println("4to7" + player);
            } else if (NumberUtil.between(l, 7L, 5000L)) {
                List<String> list = timeMap.get("7");
                list.add(player.getNickName());
                timeMap.put("7", list);
                System.out.println("7" + player);
            }
        }

        List<String> day24 = timeMap.get("2to4");
        mailContent.append("【警告】2天以上不在线成员：").append(Arrays.toString(day24.toArray())).append(lineBreak);
        List<String> day47 = timeMap.get("4to7");
        mailContent.append("【警告】4天以上不在线成员：").append(Arrays.toString(day47.toArray())).append(lineBreak);
        List<String> day7 = timeMap.get("7");
        mailContent.append("【警告】7天以上不在线成员：").append(Arrays.toString(day7.toArray())).append(lineBreak);

    }

    private static void countObj(Map<Long, List<Player>> timeMap, Player clanMember, long lastLoginDay) {
        if (timeMap.containsKey(lastLoginDay)) {
            List<Player> players = timeMap.get(lastLoginDay);
            players.add(clanMember);
        } else {
            List<Player> players = new ArrayList<>();
            players.add(clanMember);
            timeMap.put(lastLoginDay, players);
        }
    }

    /**
     * @param info
     * @param lineBreak
     * @param members
     * @param coLeaderThreshold
     * @param role
     */
    private static void showCanUpgrade(StringBuilder info, String lineBreak,
                                       List<Player> members,
                                       int coLeaderThreshold, CrEnum.ClanRoleEnum role) {
        info.append("可晋升的" + role.getRoleName() + "名单,捐卡大于" + coLeaderThreshold).append(lineBreak);

        int count = 0;
        for (Player member : members) {
            if (Integer.valueOf(member.getDonate()) > coLeaderThreshold) {
                info.append("玩家【" + member.getNickName() + "】 当前捐卡数【" + member.getDonate() + "】 暂位于部落第" + member.getTempRank() + "名").append(lineBreak);
                count++;
            }
        }
        if (count == 0) {
            info.append("暂无").append(lineBreak);
        }
    }

    private static ClanInfoVo queryClanInfo(String clanTag) throws IOException {
        String url = "https://royaleapi.com/clan/" + clanTag;
//        String html = HttpRequestUtil.sendGet(, null);

//        s= StringFileToolkit.file2String(new File("D:\\Users\\Administrator\\1008MyDemo\\src\\com\\util\\clanInfo.html"),"utf8");
        ClanInfoVo vo = fetchClanMembers(url);
        vo.setClanTag(clanTag);
        return vo;
    }

    private static ClanInfoVo fetchClanMembers(String url) throws IOException {
        ClanInfoVo clanInfoVo = new ClanInfoVo();
        List<Player> clanMembers = new ArrayList<>();
        Document document = Jsoup.connect(url)
                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(20000).get();

        Element uiHeader = document.getElementsByClass("ui header margin0").get(0);
        String clanName = uiHeader.text();
        // 获取表格
        Element roster = document.getElementById("roster");
        Elements userInfoElems = roster.getElementsByAttribute("data-role");
        for (Element userInfoElem : userInfoElems) {
            Player player = new Player();
            player.setTag(userInfoElem.attr("data-tag"));
            player.setRole(userInfoElem.attr("data-role"));
            Elements td = userInfoElem.getElementsByTag("td");

            String rankNow = td.get(0).attr("data-sort-value");
            String nickName = td.get(1).attr("data-sort-value");

            Elements elementsByAttribute = td.get(1).getElementsByAttribute("data-datetime");
            String lastLoginTime = elementsByAttribute.get(0).text();

            Duration durationTime = DateUtil.formatCrDurationTime(lastLoginTime);


            String trophies = td.get(7).attr("data-sort-value");
            String level = td.get(8).attr("data-sort-value");
            String donate = td.get(9).attr("data-sort-value");
            String received = td.get(10).attr("data-sort-value");


            player.setNickName(nickName);
            player.setTrophies(trophies);
            player.setLevel(level);
            player.setDonate(donate);
            player.setReceived(received);
            player.setTempRank(rankNow);
            player.setLastLogin(durationTime);

//            for (int j = 0; j < td.size(); j++) {
//                /*
//                 j=0 data-sort-value部落当前排名
//                 j=1 data-sort-value昵称
//                 j=234 图
//                 j=5 text职位
//                 j=6 ？？
//                 j=7 text杯数
//                 j=8 国王塔等级
//                 j=9 data-sort-value捐卡数目
//                 j=10 data-sort-value求卡数目
//                 */
////                System.out.println("NUMN"+j+td.get(j));
//            }


            clanMembers.add(player);
//            System.out.println(player);
        }
        clanInfoVo.setClanMembers(clanMembers);
        clanInfoVo.setClanName(clanName);
        return clanInfoVo;
    }
}
