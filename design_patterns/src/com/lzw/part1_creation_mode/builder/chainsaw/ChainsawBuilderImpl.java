package com.lzw.part1_creation_mode.builder.chainsaw;

/**
 * 链锯建筑者（具体建筑者）
 */
public class ChainsawBuilderImpl implements ChainsawBuilder{

    private Chainsaws chainsaws;

    public ChainsawBuilderImpl() {
        chainsaws = new Chainsaws();
    }


    @Override
    public void battery() {
        chainsaws.setBattery("普通锂电池");
    }

    @Override
    public void motor() {
        chainsaws.setMotor("普通铝电动机");
    }

    @Override
    public void reductionGearbox() {
        chainsaws.setReductionGearbox("普通减速箱");
    }

    @Override
    public void hood() {
        chainsaws.setHood("普通PVC塑料");
    }

    @Override
    public void handle() {
        chainsaws.setHandle("普通PVC塑料");
    }

    @Override
    public void switches() {
        chainsaws.setSwitches("普通拉线开关");
    }

    @Override
    public void plug() {
        chainsaws.setPlug("普通三口插头");
    }

    @Override
    public void circularSaw() {
        chainsaws.setCircularSaw("普通钢锯片");
    }

    @Override
    public Chainsaws getChainsaws() {
        return chainsaws;
    }
}
