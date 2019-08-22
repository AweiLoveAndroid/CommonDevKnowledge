package com.lzw.part1_creation_mode.builder.chainsaw;

/**
 * 测试类
 */
public class Test {

    public static void main(String[] args) {

        HardwareStoreBoss hardwareStoreBoss = new HardwareStoreBoss();

        Chainsaws chainsaws = hardwareStoreBoss.notify(new ChainsawBuilderImpl());
        System.out.println(chainsaws.toString());

        // 新链锯
        Chainsaws chainsaws2 = hardwareStoreBoss.notify(new ChainsawBuilderImpl2());
        System.out.println(chainsaws2.toString());
    }


}
