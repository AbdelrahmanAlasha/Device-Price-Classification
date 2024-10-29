package com.maids.maids;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeviceService {
    @Autowired

    private DeviceRepository deviceRepository;

    public List<Device> getAllDevices() {
        return (List<Device>) deviceRepository.findAll();

    }

    public Device getDeviceById(Long id) {
        try {
            return deviceRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Device not found for ID: " + id);
        }
    }

    public Device createDevice(Map<String, Object> device) {
        Device testDevice = new Device();

        testDevice.setBatteryPower((Integer) device.get("battery_power"));
        testDevice.setBlue((Integer) device.get("blue"));
        testDevice.setClockSpeed((Double) device.get("clock_speed"));
        testDevice.setDualSim((Integer) device.get("dual_sim"));
        testDevice.setFc((Integer) device.get("fc"));
        testDevice.setFourG((Integer) device.get("four_g"));
        testDevice.setIntMemory((Integer) device.get("int_memory"));
        testDevice.setmDep((Double) device.get("m_dep"));
        testDevice.setMobileWt((Integer) device.get("mobile_wt"));
        testDevice.setnCores((Integer) device.get("n_cores"));
        testDevice.setPc((Integer) device.get("pc"));
        testDevice.setPxHeight((Integer) device.get("px_height"));
        testDevice.setPxWidth((Integer) device.get("px_width"));
        testDevice.setRam((Integer) device.get("ram"));
        testDevice.setScH((Integer) device.get("sc_h"));
        testDevice.setScW((Integer) device.get("sc_w"));
        testDevice.setTalkTime((Integer) device.get("talk_time"));
        testDevice.setThreeG((Integer) device.get("three_g"));
        testDevice.setTouchScreen((Integer) device.get("touch_screen"));
        testDevice.setWifi((Integer) device.get("wifi"));
        deviceRepository.save(testDevice);
        return testDevice;

    }

}
