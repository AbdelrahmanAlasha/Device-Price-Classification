package com.maids.maids;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/devices")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Device device = deviceService.getDeviceById(id);

        return device != null ? ResponseEntity.ok(device) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Device> createDevice(@RequestBody Map<String, Object> device) {
        Device createdDevice = deviceService.createDevice(device);
        return ResponseEntity.ok(createdDevice);

    }
    
    @GetMapping("/predict/{id}")
    public ResponseEntity<String> predictDevice(@PathVariable Long id) {
        try {
            ResponseEntity<String> response = deviceService.sendDeviceToFlask(id);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during prediction");
        }
    }
}
