package com.util.constant;

/**
 * @author Tianqi.Zhang
 * @date 2020/5/30
 * @time 20:18
 * @package com.util.cr
 * @project 1008MyDemo
 * @description
 */
public class CrEnum {


    public enum ClanRoleEnum {
        Leader("首领"),
        CoLeader("副首领"),
        Elder("长老"),
        Member("成员");
        private String roleName;

        ClanRoleEnum(String roleName) {
            this.roleName = roleName;
        }

        public String getRoleName() {
            return roleName;
        }
    }

    public enum ClanTagEnum {
        图书罐("图书罐","PCRQUPLG"),
        诸事皆宜("诸事皆宜","9QULU2RJ"),
        白世家族("白世家族","9JYCYYJG"),
        小鸣同学("小鸣同学","9PQ9YG0");
        private String clanName;
        private String clanTag;

        ClanTagEnum(String clanName, String clanTag) {
            this.clanName = clanName;
            this.clanTag = clanTag;
        }

        public String getClanName() {

            return clanName;
        }

        public void setClanName(String clanName) {
            this.clanName = clanName;
        }

        public String getClanTag() {
            return clanTag;
        }

        public void setClanTag(String clanTag) {
            this.clanTag = clanTag;
        }

        public String getRoleName() {
            return clanName;
        }
    }

}
