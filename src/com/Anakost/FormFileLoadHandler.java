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
            "  <form action=\"http://localhost:8080/upload\" enctype=\"multipart/form-data\" method=\"post\">\n" +
            "   <div>File1: <input type='file' name='file +&+ \"1\"'></div>\n" +
            "   <div>Value1: <input type='text' name='value1'></div>\n" +
            "   <div>File2: <input type='file' name='file2'></div>\n" +
            "   <div>Value2: <input type='text' name='value2'></div>\n" +
            "   <div>File multiple: <input type='file' name='fileMul' multiple></div>\n" +
            "   <div><input type='submit' value='Отправить'></div>\n" +
            "  </form> \n" +
            " </body>\n" +
            "</html>");
        writer.close();

    }
}
