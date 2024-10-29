package com.maids.maids;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer batteryPower;
    private Integer blue;
    private Double clockSpeed;
    private Integer dualSim;
    private Integer fc;
    private Integer fourG;
    private Integer intMemory;
    private Double mDep;
    private Integer mobileWt;
    private Integer nCores;
    private Integer pc;
    private Integer pxHeight;
    private Integer pxWidth;
    private Integer ram;
    private Integer scH;
    private Integer scW;
    private Integer talkTime;
    private Integer threeG;
    private Integer touchScreen;
    private Integer wifi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(Integer batteryPower) {
        this.batteryPower = batteryPower;
    }

    public Integer getBlue() {
        return blue;
    }

    public void setBlue(Integer blue) {
        this.blue = blue;
    }

    public Double getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(Double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public Integer getDualSim() {
        return dualSim;
    }

    public void setDualSim(Integer dualSim) {
        this.dualSim = dualSim;
    }

    public Integer getFc() {
        return fc;
    }

    public void setFc(Integer fc) {
        this.fc = fc;
    }

    public Integer getFourG() {
        return fourG;
    }

    public void setFourG(Integer fourG) {
        this.fourG = fourG;
    }

    public Integer getIntMemory() {
        return intMemory;
    }

    public void setIntMemory(Integer intMemory) {
        this.intMemory = intMemory;
    }

    public Double getmDep() {
        return mDep;
    }

    public void setmDep(Double mDep) {
        this.mDep = mDep;
    }

    public Integer getMobileWt() {
        return mobileWt;
    }

    public void setMobileWt(Integer mobileWt) {
        this.mobileWt = mobileWt;
    }

    public Integer getnCores() {
        return nCores;
    }

    public void setnCores(Integer nCores) {
        this.nCores = nCores;
    }

    public Integer getPc() {
        return pc;
    }

    public void setPc(Integer pc) {
        this.pc = pc;
    }

    public Integer getPxHeight() {
        return pxHeight;
    }

    public void setPxHeight(Integer pxHeight) {
        this.pxHeight = pxHeight;
    }

    public Integer getPxWidth() {
        return pxWidth;
    }

    public void setPxWidth(Integer pxWidth) {
        this.pxWidth = pxWidth;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getScH() {
        return scH;
    }

    public void setScH(Integer scH) {
        this.scH = scH;
    }

    public Integer getScW() {
        return scW;
    }

    public void setScW(Integer scW) {
        this.scW = scW;
    }

    public Integer getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(Integer talkTime) {
        this.talkTime = talkTime;
    }

    public Integer getThreeG() {
        return threeG;
    }

    public void setThreeG(Integer threeG) {
        this.threeG = threeG;
    }

    public Integer getTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(Integer touchScreen) {
        this.touchScreen = touchScreen;
    }

    public Integer getWifi() {
        return wifi;
    }

    public void setWifi(Integer wifi) {
        this.wifi = wifi;
    }

}
