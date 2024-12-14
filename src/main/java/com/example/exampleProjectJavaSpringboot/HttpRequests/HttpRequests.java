package com.example.exampleProjectJavaSpringboot.HttpRequests;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpRequests {

    private static final OkHttpClient client = new OkHttpClient();

    public static void sendRequest(String url) throws Exception {
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            Headers respoceHeaders = response.headers();
            for (int i = 0; i < respoceHeaders.size(); i++) {
                System.out.println(respoceHeaders.name(i) + ": " + respoceHeaders.value(i));
            }

            if (response.body() != null) System.out.println(response.body().string());
        }
    }

    public static void sendSmsToNumber(String message, String phoneNumber) throws Exception {

    }

}
