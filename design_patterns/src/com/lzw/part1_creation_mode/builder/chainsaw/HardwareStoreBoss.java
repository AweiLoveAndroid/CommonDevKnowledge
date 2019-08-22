package com.lzw.part1_creation_mode.builder.chainsaw;

/**
 * 五金店老板（验收方）
 */
public class HardwareStoreBoss {

    // 电话通知建造方，查看进度如何了
    public Chainsaws notify(ChainsawBuilder builder){

        // 蓄电池
        builder.battery();
        // 电动机
        builder.motor();
        // 减速箱
        builder.reductionGearbox();
        // 防护罩
        builder.hood();
        // 手柄
        builder.handle();
        // 开关
        builder.switches();
        // 插头
        builder.plug();
        // 圆锯片
        builder.circularSaw();
        return builder.getChainsaws();
    }
}
