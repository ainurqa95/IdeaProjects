package models;

import java.io.Serializable;
import java.util.function.Consumer;

/**
 * Created by ainur on 03.11.16.
 */
public class Server extends NetworкConnection {

    private int port;
    public Server(int port , Consumer<Serializable> onReceiveCallBack) {
        super(onReceiveCallBack);
        this.port = port;
    }

    @Override
    protected boolean isServer() {
        return true;
    }

    @Override
    protected String getIP() {
        return null;
    }

    @Override
    protected int getPort() {
        return this.port;
    }
}
