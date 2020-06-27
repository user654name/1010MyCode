package com.util.model.vo;

import com.util.model.Player;

/**
 * @author Tianqi.Zhang
 * @date 2020/5/31
 * @time 0:07
 * @package com.util.model.vo
 * @project 1008MyDemo
 * @description
 */
public class ClanWarRecord {
    /*** 玩家信息 ***/
    private Player player;
    /*** 部落战日期 ***/
    private String warDate;
    /*** 终极战场次 ***/
    private String battlePlayed;
    /*** 终极战胜场 ***/
    private String battleWin;
    /*** 集卡日集卡数 ***/
    private String cardsEarned;

    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return "ClanWarRecord{" +
                "player=" + player.getNickName() +
                ", warDate='" + warDate + '\'' +
                ", battlePlayed='" + battlePlayed + '\'' +
                ", battleWin='" + battleWin + '\'' +
                ", cardsEarned='" + cardsEarned + '\'' +
                '}';
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getWarDate() {
        return warDate;
    }

    public void setWarDate(String warDate) {
        this.warDate = warDate;
    }

    public String getBattlePlayed() {
        return battlePlayed;
    }

    public void setBattlePlayed(String battlePlayed) {
        this.battlePlayed = battlePlayed;
    }

    public String getBattleWin() {
        return battleWin;
    }

    public void setBattleWin(String battleWin) {
        this.battleWin = battleWin;
    }

    public String getCardsEarned() {
        return cardsEarned;
    }

    public void setCardsEarned(String cardsEarned) {
        this.cardsEarned = cardsEarned;
    }
}
