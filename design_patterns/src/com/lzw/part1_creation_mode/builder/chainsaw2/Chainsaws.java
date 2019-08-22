package com.lzw.part1_creation_mode.builder.chainsaw2;

/**
 * 产品（链锯）
 * 保持不变
 */
public class Chainsaws {

    // 蓄电池
    private String battery;
    // 电动机
    private String motor;
    // 减速箱
    private String reductionGearbox;
    // 防护罩
    private String hood;
    // 手柄
    private String handle;
    // 开关
    private String switches;
    // 插头
    private String plug;
    // 圆锯片
    private String circularSaw;


    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getReductionGearbox() {
        return reductionGearbox;
    }

    public void setReductionGearbox(String reductionGearbox) {
        this.reductionGearbox = reductionGearbox;
    }

    public String getHood() {
        return hood;
    }

    public void setHood(String hood) {
        this.hood = hood;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getSwitches() {
        return switches;
    }

    public void setSwitches(String switches) {
        this.switches = switches;
    }

    public String getPlug() {
        return plug;
    }


    public void setPlug(String plug) {
        this.plug = plug;
    }

    public String getCircularSaw() {
        return circularSaw;
    }

    public void setCircularSaw(String circularSaw) {
        this.circularSaw = circularSaw;
    }


    @Override
    public String toString() {
        return "Chainsaws{" +
                "\n battery='" + battery + '\'' +
                ", motor='" + motor + '\'' +
                ", reductionGearbox='" + reductionGearbox + '\'' +
                ", hood='" + hood + '\'' +
                ", handle='" + handle + '\'' +
                ", switches='" + switches + '\'' +
                ", plug='" + plug + '\'' +
                ", circularSaw='" + circularSaw + '\'' +
                "链锯已经做好了\n" + '}';
    }


}
