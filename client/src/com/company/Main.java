package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5324);// подключаемся к сервру
            BufferedReader  in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // формиру
            // ем поток ввода client.getInputStream()
            PrintWriter out = new PrintWriter( (socket.getOutputStream()),true);
            // true очистка канала связи после считывания
            Scanner scan = new Scanner(System.in); // пишем на клиенте что-то
            System.out.println("введите имя");
            String name = scan.nextLine(); // считываем имя
            out.println(name); // отправили серверу
            // ервер вернет приветствие
            String hello = in.readLine(); // считываем от сервера
            System.out.println(hello);
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
