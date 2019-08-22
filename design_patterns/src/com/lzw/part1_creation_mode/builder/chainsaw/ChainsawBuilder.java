package com.lzw.part1_creation_mode.builder.chainsaw;

/**
 * 链锯建筑者
 */
public interface ChainsawBuilder {

    // 蓄电池
    void battery();
    // 电动机
    void motor();
    // 减速箱
    void reductionGearbox();
    // 防护罩
    void hood();
    // 手柄
    void handle();
    // 开关
    void switches();
    // 插头
    void plug();
    // 圆锯片
    void circularSaw();

    // 获取链锯（产品）的实例
    Chainsaws getChainsaws();

}
