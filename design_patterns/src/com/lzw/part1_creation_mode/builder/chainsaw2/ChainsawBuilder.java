package com.lzw.part1_creation_mode.builder.chainsaw2;

/**
 * 链锯建筑者
 */
public interface ChainsawBuilder {

    // 蓄电池
    ChainsawBuilder battery(String name);
    // 电动机
    ChainsawBuilder motor(String name);
    // 减速箱
    ChainsawBuilder reductionGearbox(String name);
    // 防护罩
    ChainsawBuilder hood(String name);
    // 手柄
    ChainsawBuilder handle(String name);
    // 开关
    ChainsawBuilder switches(String name);
    // 插头
    ChainsawBuilder plug(String name);
    // 圆锯片
    ChainsawBuilder circularSaw(String name);

    // 获取链锯（产品）的实例
    Chainsaws getChainsaws();

}
