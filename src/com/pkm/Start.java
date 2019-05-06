package com.pkm;

import com.pkm.db.PkmDb;
import com.pkm.db.TypeDb;
import com.pkm.model.Gamer;
import com.pkm.model.Pkm;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Tianqi.Zhang
 * @date 2019/4/30
 * @time 14:05
 * @package com.pkm
 * @project 1008MyDemo
 * @description
 */
public class Start {


    public static void main(String[] args) {

        // 初始化
        Map<Integer, Pkm> init1 = new HashMap<>();
        init1.put(1, getPkmById(1));
        init1.put(2, getPkmById(4));
        init1.put(3, getPkmById(7));
        Map<Integer, Pkm> init2 = init1;
        Gamer plr = new Gamer("you", 200);
        Gamer com = new Gamer("com", 200);
        plr.setPkms(init1);
        com.setPkms(init2);
        Pkm pPkm = null;
        Pkm cPkm = null;

        boolean over = false;
        while (!over) {
            // Start
            printGamerInfo(plr);
            printGamerInfo(com);
            System.out.println("please choose your pkm ");

            // plr choose and com choose
            int pOrder = waitInputInt();
            Map<Integer, Pkm> pPkms = plr.getPkms();
            pPkm = pPkms.get(pOrder);
            int cOrder = new Random().nextInt(3) + 1;
            Map<Integer, Pkm> cPkms = com.getPkms();
            cPkm = cPkms.get(cOrder);

            // count Hp
            countHpAndAdjustPkm(plr, com, pPkm, cPkm, pOrder, pPkms);
            countHpAndAdjustPkm(com, plr, cPkm, pPkm, cOrder, cPkms);

            if (plr.getHp() < 0) {
                System.out.println("You Lose ！");
                over = true;
            } else if (com.getHp() < 0) {
                System.out.println("You Win ！");
                over = true;
            }
        }


    }

    private static void countHpAndAdjustPkm(Gamer att, Gamer def, Pkm attP, Pkm defP, int attpOrder, Map<Integer, Pkm> attpPkms) {
        int i = countHp(att, def, attP, defP);
        if (i == 1) {
            int exp = attP.getExp() + 20;
            if (exp > 100) {
                Integer evolutionId = attP.getEvolutionId();
                if (evolutionId != 0) {
                    Pkm newPkm = getPkmById(evolutionId);
                    attpPkms.put(attpOrder, newPkm);
                    att.setPkms(attpPkms);
                    System.out.println("Congratulations！"+attP.getName()+" evolve to "+newPkm.getName()+"!");
                }
            } else {
                attP.setExp(exp);
            }
        }
    }

    private static int countHp(Gamer plr, Gamer com, Pkm pPkm, Pkm cPkm) {
        Double pHitEffect = TypeDb.aHitd(pPkm, cPkm);
        double pHit = pHitEffect * pPkm.getAtt();
        System.out.println(plr.getGamerName() + "'s "
                + pPkm.getName() + " hurt " + pHit + " point to " + com.getGamerName() + "'s "
                + cPkm.getName());
        com.setHp((int) (com.getHp() - pHit));
        if (pHitEffect > 1) {
            return 1;
        }
        return 0;
    }

    private static int waitInputInt() {
        int i = 0;
        boolean inputOk = false;
        while (!inputOk) {
            try {
                Scanner scanner = new Scanner(System.in);
                i = scanner.nextInt();
                inputOk = true;
            } catch (Exception e) {
                System.out.println("not a int , please input again");
            }
        }
        return i;
    }

    private static void printGamerInfo(Gamer plr) {
        System.out.println(plr.getGamerName() + "'s HP is " + plr.getHp() + " , pkm : ");
        int num = plr.getHp() / 10;
        for (int i = 0; i < num; i++) {
            System.out.print("■");
        }
        System.out.println();
        for (Integer order : plr.getPkms().keySet()) {
            Pkm pkm = plr.getPkms().get(order);
            System.out.print(order + ")" + pkm.getName() + " [type-" + pkm.getType() + "] [A-" + pkm.getAtt() + "]");
            int i = pkm.getExp() / 20;
            for (int j = 0; j < i; j++) {
                System.out.print("■");
            }
            System.out.println();
        }
    }

    private static Pkm getPkmById(int id) {
        Map<Integer, Pkm> allPkmMap = getAllPkmMap();
        return allPkmMap.get(id);
    }


    private static Map<Integer, Pkm> getAllPkmMap() {
        return PkmDb.getAllPkmMap();
    }
}
