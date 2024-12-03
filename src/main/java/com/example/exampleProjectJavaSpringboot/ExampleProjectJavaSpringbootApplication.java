package com.example.exampleProjectJavaSpringboot;

import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
@EnableScheduling
@SpringBootApplication
public class ExampleProjectJavaSpringbootApplication {

	private static boolean enableFirebase = true;

	public static void initFireBaseApp() throws IOException {
		FileInputStream serviceAccount = new FileInputStream("hygrometer-8de9a-firebase-adminsdk-g7iae-b3f09dcbe2.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();
		FirebaseApp.initializeApp(options);
		System.out.println("init Firebase for cloudMessaging");
	}

	public static void main(String[] args) throws IOException {
		if (enableFirebase) initFireBaseApp();
		SpringApplication.run(ExampleProjectJavaSpringbootApplication.class, args);
	}

}
