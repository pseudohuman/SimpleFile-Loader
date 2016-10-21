package com.Anakost;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * Created by Анатолій on 21.10.2016.
 */
public class FormFileLoadHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        httpExchange.setAttribute("status-code",HttpURLConnection.HTTP_OK);
        OutputStream responseBody = httpExchange.getResponseBody();
        httpExchange.sendResponseHeaders(200,0);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(responseBody, StandardCharsets.UTF_8));
        writer.write("<!DOCTYPE html>\n" +
            "<html>\n" +
            " <head>\n" +
            "  <meta charset=\"utf-8\">\n" +
            "  <title>Отправка файла на сервер</title>\n" +
            " </head>\n" +
            " <body>\n" +
            "  <form action=\"http://localhost:8080/upload\" enctype=\"multipart/form-data\" method=\"post\">\n" +
            "   <p><input type=\"file\" name=\"f\">\n" +
            "   <input type=\"submit\" value=\"Отправить\"></p>\n" +
            "  </form> \n" +
            " </body>\n" +
            "</html>");
        writer.close();

    }
}
