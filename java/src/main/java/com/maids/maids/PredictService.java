package com.maids.maids;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PredictService {

    private final RestTemplate restTemplate;
    private final String flaskServerUrl = "http://localhost:5000/predict/";

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public PredictService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String predict(Long id) {
        try {
            // Retrieve device data by ID using JPA
            Device device = entityManager.find(Device.class, id);

            if (device == null) {
                throw new RuntimeException("Data not found for ID: " + id);
            }

            // Extract relevant features from the device object to create a Map
            Map<String, Object> data = new HashMap<>();
            data.put("batteryPower", device.getBatteryPower());
            data.put("blue", device.getBlue());
            data.put("clockSpeed", device.getClockSpeed());
            data.put("dualSim", device.getDualSim());
            data.put("fc", device.getFc());
            data.put("fourG", device.getFourG());
            data.put("intMemory", device.getIntMemory());
            data.put("mDep", device.getmDep());
            data.put("mobileWt", device.getMobileWt());
            data.put("nCores", device.getnCores());
            data.put("pc", device.getPc());
            data.put("pxHeight", device.getPxHeight());
            data.put("pxWidth", device.getPxWidth());
            data.put("ram", device.getRam());
            data.put("scH", device.getScH());
            data.put("scW", device.getScW());
            data.put("talkTime", device.getTalkTime());
            data.put("threeG", device.getThreeG());
            data.put("touchScreen", device.getTouchScreen());
            data.put("wifi", device.getWifi());

            // Convert data to JSON string
            String jsonData = new ObjectMapper().writeValueAsString(data);

            ResponseEntity<String> response = restTemplate.postForEntity(flaskServerUrl, jsonData, String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody(); // Return prediction result
            } else {
                throw new RuntimeException("Error calling Flask server: " + response.getStatusCode());
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting data to JSON: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving data from database: " + e.getMessage());
        }
    }
}