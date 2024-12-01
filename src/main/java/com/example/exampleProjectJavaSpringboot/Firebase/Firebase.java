package com.example.exampleProjectJavaSpringboot.Firebase;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;

public class Firebase {

    public void sendMessage(String token, String info) throws FirebaseMessagingException {
        Message message = Message.builder()
                .putData("message", info)
                .setToken(token)
                .build();
        String response = FirebaseMessaging.getInstance().send(message);
        System.out.println("Successfully sent message: " + response);
    }

}
