package com.python;

/**
 * @author Tianqi.Zhang
 * @date 2020/2/6
 * @time 16:24
 * @package com.python
 * @project 1008MyDemo
 * @description
 */
public class DayDayUpJava {

    /**
     * 工作日进步 休息日退步 模拟一年
     *
     * @param args
     */
    public static void main(String[] args) {
        double init = 1D;
        double upFuDu = 0.01D;

        

        dayUp(init, upFuDu);

    }

    private static double dayUp(double init, double fuDu) {
        init = init * (1 + fuDu);
        return init;
    }

    private static double dayDown(double init, double fuDu) {
        init = init * (1 - fuDu);
        return init;
    }
}
