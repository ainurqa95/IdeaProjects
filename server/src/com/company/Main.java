package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try {
            ServerSocket listener = new ServerSocket(5324);// подали порт
            System.out.println("Сервер запущен");
            while(true){// обрабатываем подключение одного клиента
                Socket client = listener.accept();// переходим в режим ожидания сервера
                // нужно начать диалог с клиентом
                System.out.println("подключился клиент");
                (new ClientDialog(client)).start(); // стартуем поток
                // start вызывает run

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

