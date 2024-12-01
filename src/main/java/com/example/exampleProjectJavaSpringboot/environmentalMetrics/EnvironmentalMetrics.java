package com.example.exampleProjectJavaSpringboot.environmentalMetrics;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class EnvironmentalMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDateTime created_at;

    private double temperature;

    private double humidity;


    public void setCreated_at() {
        this.created_at = LocalDateTime.now();
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public Integer getId() {
        return id;
    }
    public LocalDateTime getCreated_at() {
        return created_at;
    }
    public double getHumidity() {
        return humidity;
    }
    public double getTemperature() {
        return temperature;
    }
}
