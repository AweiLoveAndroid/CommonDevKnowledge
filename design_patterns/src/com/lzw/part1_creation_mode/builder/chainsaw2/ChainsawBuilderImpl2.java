package com.lzw.part1_creation_mode.builder.chainsaw2;

/**
 * 链锯建筑者（具体建筑者）
 */
public class ChainsawBuilderImpl2 implements ChainsawBuilder {

    private Chainsaws chainsaws;

    public ChainsawBuilderImpl2() {
        chainsaws = new Chainsaws();
    }

    @Override
    public ChainsawBuilder battery(String name) {
        chainsaws.setBattery(name);
        return this;
    }

    @Override
    public ChainsawBuilder motor(String name) {
        chainsaws.setMotor(name);
        return this;
    }

    @Override
    public ChainsawBuilder reductionGearbox(String name) {
        chainsaws.setReductionGearbox(name);
        return this;
    }

    @Override
    public ChainsawBuilder hood(String name) {
        chainsaws.setHood(name);
        return this;
    }

    @Override
    public ChainsawBuilder handle(String name) {
        chainsaws.setHandle(name);
        return this;
    }

    @Override
    public ChainsawBuilder switches(String name) {
        chainsaws.setSwitches(name);
        return this;
    }

    @Override
    public ChainsawBuilder plug(String name) {
        chainsaws.setPlug(name);
        return this;
    }

    @Override
    public ChainsawBuilder circularSaw(String name) {
        chainsaws.setCircularSaw(name);
        return this;
    }

    @Override
    public Chainsaws getChainsaws() {
        return chainsaws;
    }
}
