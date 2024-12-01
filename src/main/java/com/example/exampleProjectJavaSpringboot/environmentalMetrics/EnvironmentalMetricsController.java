package com.example.exampleProjectJavaSpringboot.environmentalMetrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
@RequestMapping(path = "/environmentalMetrics")
public class EnvironmentalMetricsController {

    @Autowired
    EnvironmentalMetricsService environmentalMetricsService;

    @PostMapping(path = "/add")
    public @ResponseBody String addDateObject(@PathVariable double temperature, @PathVariable double humidity) {
        return environmentalMetricsService.addDataObject(temperature, humidity);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<EnvironmentalMetrics> getAllData() {
        return environmentalMetricsService.getAllData();
    }

    @GetMapping(path = "/allToday")
    public @ResponseBody List<EnvironmentalMetrics> getAllForToday() {
        return environmentalMetricsService.getDataForToday();
    }

}
