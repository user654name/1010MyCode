package com.util.model;

import java.time.Duration;

/**
 * @author Tianqi.Zhang
 * @date 2020/5/29
 * @time 21:48
 * @package com.util
 * @project 1008MyDemo
 * @description
 */
public class Player {
    /***  ***/
    private String tag;
    /***  ***/
    private String nickName;
    /***  ***/
    private String role;
    /***  ***/
    private String trophies;
    /***  ***/
    private String level;
    /***  ***/
    private String donate;
    /***  ***/
    private String received;
    /***  ***/
    private String tempRank;

    @Override
    public String toString() {
        return "Player{" +
                "tag='" + tag + '\'' +
                ", nickName='" + nickName + '\'' +
                ", role='" + role + '\'' +
                ", trophies='" + trophies + '\'' +
                ", level='" + level + '\'' +
                ", donate='" + donate + '\'' +
                ", received='" + received + '\'' +
                ", tempRank='" + tempRank + '\'' +
                ", lastLogin=" + lastLogin +
                '}';
    }

    public Duration getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Duration lastLogin) {
        this.lastLogin = lastLogin;
    }

    /***  ***/
    private Duration lastLogin;

    public String getTempRank() {
        return tempRank;
    }

    public void setTempRank(String tempRank) {
        this.tempRank = tempRank;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTrophies() {
        return trophies;
    }

    public void setTrophies(String trophies) {
        this.trophies = trophies;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDonate() {
        return donate;
    }

    public void setDonate(String donate) {
        this.donate = donate;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }
}
