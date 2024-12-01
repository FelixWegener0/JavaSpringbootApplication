package com.example.exampleProjectJavaSpringboot.environmentalMetrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnvironmentalMetricsService {

    @Autowired
    EnvironmentalMetricsRepository environmentalMetricsRepository;

    public String addDataObject(double temperature, double humidity) {
        EnvironmentalMetrics data = new EnvironmentalMetrics();

        data.setTemperature(temperature);
        data.setHumidity(humidity);
        data.setCreated_at();

        environmentalMetricsRepository.save(data);
        return "add new dataset";
    }

    public Iterable<EnvironmentalMetrics> getAllData() {
        return environmentalMetricsRepository.findAll();
    }

    public List<EnvironmentalMetrics> getDataForToday() {
        Iterable<EnvironmentalMetrics> data = environmentalMetricsRepository.findAll();
        List<EnvironmentalMetrics> result = new ArrayList<EnvironmentalMetrics>();

        data.forEach((value) -> {
            if (value.getCreated_at().isEqual(LocalDate.now())) {
                result.add(value);
            }
        });

        return result;
    }

}
