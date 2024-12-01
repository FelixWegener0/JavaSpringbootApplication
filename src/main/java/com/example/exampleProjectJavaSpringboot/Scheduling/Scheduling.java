package com.example.exampleProjectJavaSpringboot.Scheduling;

import com.example.exampleProjectJavaSpringboot.Firebase.Firebase;
import com.example.exampleProjectJavaSpringboot.User.User;
import com.example.exampleProjectJavaSpringboot.User.UserService;
import com.example.exampleProjectJavaSpringboot.environmentalMetrics.EnvironmentalMetrics;
import com.example.exampleProjectJavaSpringboot.environmentalMetrics.EnvironmentalMetricsService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class Scheduling {

    private final double maxHumidValue = 60.0;
    private final Integer adminId = 1;

    Firebase firebase;

    @Autowired
    EnvironmentalMetricsService environmentalMetricsService;

    @Autowired
    UserService userService;

    // 30 minutes between calls
    @Scheduled(fixedDelay = 1000 * 60 * 30)
    public void checkLastHumid() {
        System.out.println("Scheduled task to check last humid value");
        Optional<User> user = userService.getUserById(adminId);

        Iterable<EnvironmentalMetrics> data = environmentalMetricsService.getDataForToday();
        data.forEach((value) -> {
            if (value.getHumidity() > maxHumidValue && value.getCreated_at().isAfter(LocalDateTime.now().minusMinutes(10))) {
                System.out.println("Humid to high in room: " + value.getRoom() + " send message with Firebase to mobileApp");
                user.ifPresentOrElse((userInfo) -> {
                    try {
                        firebase.sendMessage(userInfo.getMobileAppToken(), "Humidity to high in room: " + value.getRoom());
                    } catch (FirebaseMessagingException e) {
                        throw new RuntimeException(e);
                    }
                }, () -> {
                    System.out.println("Admin user was not found to send Firebase Message should have id 1");
                });
            }
        });
    }
}
