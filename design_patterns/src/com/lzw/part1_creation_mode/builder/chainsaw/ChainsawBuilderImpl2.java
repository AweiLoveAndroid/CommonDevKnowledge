package com.lzw.part1_creation_mode.builder.chainsaw;

/**
 * 链锯建筑者（具体建筑者）
 */
public class ChainsawBuilderImpl2 implements ChainsawBuilder{

    private Chainsaws chainsaws;

    public ChainsawBuilderImpl2() {
        chainsaws = new Chainsaws();
    }


    @Override
    public void battery() {
        chainsaws.setBattery("环保大容量锂电池");
    }

    @Override
    public void motor() {
        chainsaws.setMotor("动力强耐高温散热好的纯铜电机");
    }

    @Override
    public void reductionGearbox() {
        chainsaws.setReductionGearbox("减震变频高功率变速箱");
    }

    @Override
    public void hood() {
        chainsaws.setHood("加厚加固耐磨抗打击防护罩");
    }

    @Override
    public void handle() {
        chainsaws.setHandle("人体工体学包胶手柄");
    }

    @Override
    public void switches() {
        chainsaws.setSwitches("调速防误触智能开关");
    }

    @Override
    public void plug() {
        chainsaws.setPlug("环保防触电插头");
    }

    @Override
    public void circularSaw() {
        chainsaws.setCircularSaw("高硬度锯片");
    }

    @Override
    public Chainsaws getChainsaws() {
        return chainsaws;
    }
}
