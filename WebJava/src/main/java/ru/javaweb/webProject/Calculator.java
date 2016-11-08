package ru.javaweb.webProject;

import org.omg.CORBA.UserException;

/**
 * Created by ainur on 23.10.16.
 */
public class Calculator {


    private int result;

    public  void add (int ... params){
        for (int param : params){
            this.result +=param;
        }
    }
    public int getResult(){
        return this.result;

    }

    /**
     *
     * @param args
     * комментарии
     * @throws Exception
     */
    public void devide (int ... args) throws Exception {

        if(args.length > 0){
           this.result = args[0];

            for (int i = 1; i < args.length; i++) {
                if(args[i] == 0){
                    throw new IllegalArgumentException("div by 0");

                }
                this.result = this.result / args[i];

            }

        }else {
            throw new Exception("Не веерно введены параметры");
        }


    }
}
