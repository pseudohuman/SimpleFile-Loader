package com.Anakost;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8080);
        server.bind(inetSocketAddress,0);

        server.createContext("/hello",new FormFileLoadHandler());
        server.createContext("/upload",new FileLoadHandler());
        server.start();

        // write your code here
    }
}
