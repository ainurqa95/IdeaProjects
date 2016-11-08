package models;

import java.io.Serializable;
import java.util.function.Consumer;

/**
 * Created by ainur on 03.11.16.
 */
public class Client extends NetworкConnection{

    private String IP;
    private int port;

    public Client(String IP, int port, Consumer<Serializable> onReceiveCallBack) {
        super(onReceiveCallBack);
        this.IP = IP;
        this.port = port;
    }

    @Override
    protected boolean isServer() {
        return false;
    }

    @Override
    protected String getIP() {
        return this.IP;
    }

    @Override
    protected int getPort() {
        return this.port;
    }
}
