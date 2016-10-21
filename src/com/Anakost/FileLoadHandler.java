package com.Anakost;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Анатолій on 21.10.2016.
 */
public class FileLoadHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if (httpExchange.getRequestMethod().equals("POST")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpExchange.getRequestBody()));
            reader.lines().forEach(s -> System.out.println(s));
        }
    }
}
