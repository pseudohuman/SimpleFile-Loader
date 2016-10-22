package com.Anakost;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

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
        httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK,0);
        OutputStream responseBody = httpExchange.getResponseBody();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(responseBody, StandardCharsets.UTF_8));
        writer.write("<!DOCTYPE html>\n" +
            "<html>\n" +
            " <head>\n" +
            "  <meta charset=\"utf-8\">\n" +
            "  <title>Отправка файла на сервер</title>\n" +
            " </head>\n" +
            " <body>\n" +
            "   <div><a href='/'>Back</a></div>\n" +
            " </body>\n" +
            "</html>");
        writer.close();

    }
}
