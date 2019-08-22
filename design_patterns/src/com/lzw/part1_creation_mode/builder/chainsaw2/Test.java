package com.lzw.part1_creation_mode.builder.chainsaw2;

/**
 * 测试类
 */
public class Test {

    public static void main(String[] args) {
        ChainsawBuilderImpl2 chainsawBuilderImpl2 = new ChainsawBuilderImpl2();
        Chainsaws chainsaws = chainsawBuilderImpl2.battery("环保大容量锂电池")
                .motor("动力强耐高温散热好的纯铜电机")
                .reductionGearbox("减震变频高功率变速箱")
                .hood("加厚加固耐磨抗打击防护罩")
                .handle("人体工体学包胶手柄")
                .switches("调速防误触智能开关")
                .plug("环保防触电插头")
                .circularSaw("高硬度锯片")
                .getChainsaws();

        System.out.println(chainsaws.toString());
    }


}
