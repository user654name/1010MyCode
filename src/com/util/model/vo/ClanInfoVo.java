package com.util.model.vo;

import com.util.model.Player;

import java.util.List;

/**
 * @author Tianqi.Zhang
 * @date 2020/5/30
 * @time 20:31
 * @package com.util.model.vo
 * @project 1008MyDemo
 * @description
 */
public class ClanInfoVo {
    private List<Player> clanMembers;
    private String clanTag;
    private String clanName;

    public List<Player> getClanMembers() {
        return clanMembers;
    }

    public void setClanMembers(List<Player> clanMembers) {
        this.clanMembers = clanMembers;
    }

    public String getClanTag() {
        return clanTag;
    }

    public void setClanTag(String clanTag) {
        this.clanTag = clanTag;
    }

    public String getClanName() {
        return clanName;
    }

    public void setClanName(String clanName) {
        this.clanName = clanName;
    }

    @Override
    public String toString() {
        return "ClanInfoVo{" +
                "clanMembers=" + clanMembers +
                ", clanTag='" + clanTag + '\'' +
                ", clanName='" + clanName + '\'' +
                '}';
    }
}
