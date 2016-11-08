package com.company;

import java.io.*;
import java.net.Socket;

/**
 * Created by ainur on 01.11.16.
 */
public class ClientDialog extends Thread {
    private Socket client;// сохраним информацию о потоке с конкретным клиентом
    public ClientDialog (Socket client){
        this.client = client;
    }
    public void run (){
        try {
            BufferedReader  in = new BufferedReader(new InputStreamReader(this.client.getInputStream())); // формиру
                        // ем поток ввода client.getInputStream()
            PrintWriter out = new PrintWriter( (this.client.getOutputStream()),true);
            String name = in.readLine(); // прочитали строку
            String hello = "Привет " + name + "!";
            out.println(hello); // выводим
            System.out.println(hello);
            client.close();// закрыли сокет

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
