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

    private Integer battery_power;
    private Integer blue;
    private Double clock_speed;
    private Integer dual_sim;
    private Integer fc;
    private Integer four_g;
    private Integer int_memory;
    private Double m_dep;
    private Integer mobile_wt;
    private Integer n_cores;
    private Integer pc;
    private Integer px_height;
    private Integer px_width;
    private Integer ram;
    private Integer sc_h;
    private Integer sc_w;
    private Integer talk_time;
    private Integer three_g;
    private Integer touch_screen;
    private Integer wifi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBatteryPower() {
        return battery_power;
    }

    public void setBatteryPower(Integer battery_power) {
        this.battery_power = battery_power;
    }

    public Integer getBlue() {
        return blue;
    }

    public void setBlue(Integer blue) {
        this.blue = blue;
    }

    public Double getClockSpeed() {
        return clock_speed;
    }

    public void setClockSpeed(Double clock_speed) {
        this.clock_speed = clock_speed;
    }

    public Integer getDualSim() {
        return dual_sim;
    }

    public void setDualSim(Integer dual_sim) {
        this.dual_sim = dual_sim;
    }

    public Integer getFc() {
        return fc;
    }

    public void setFc(Integer fc) {
        this.fc = fc;
    }

    public Integer getFourG() {
        return four_g;
    }

    public void setFourG(Integer four_g) {
        this.four_g = four_g;
    }

    public Integer getIntMemory() {
        return int_memory;
    }

    public void setIntMemory(Integer int_memory) {
        this.int_memory = int_memory;
    }

    public Double getmDep() {
        return m_dep;
    }

    public void setmDep(Double m_dep) {
        this.m_dep = m_dep;
    }

    public Integer getMobileWt() {
        return mobile_wt;
    }

    public void setMobileWt(Integer mobile_wt) {
        this.mobile_wt = mobile_wt;
    }

    public Integer getnCores() {
        return n_cores;
    }

    public void setnCores(Integer n_cores) {
        this.n_cores = n_cores;
    }

    public Integer getPc() {
        return pc;
    }

    public void setPc(Integer pc) {
        this.pc = pc;
    }

    public Integer getPxHeight() {
        return px_height;
    }

    public void setPxHeight(Integer px_height) {
        this.px_height = px_height;
    }

    public Integer getPxWidth() {
        return px_width;
    }

    public void setPxWidth(Integer px_width) {
        this.px_width = px_width;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getScH() {
        return sc_h;
    }

    public void setScH(Integer sc_h) {
        this.sc_h = sc_h;
    }

    public Integer getTalkTime() {
        return talk_time;
    }

    public void setTalkTime(Integer talk_time) {
        this.talk_time = talk_time;
    }

    public Integer getThreeG() {
        return three_g;
    }

    public void setThreeG(Integer three_g) {
        this.three_g = three_g;
    }

    public Integer getTouchScreen() {
        return touch_screen;
    }

    public void setTouchScreen(Integer touch_screen) {
        this.touch_screen = touch_screen;
    }

    public Integer getWifi() {
        return wifi;
    }

    public void setWifi(Integer wifi) {
        this.wifi = wifi;
    }

    public Integer getScW() {
        return sc_w;
    }

    public void setScW(Integer sc_w) {
        this.sc_w = sc_w;
    }

}
