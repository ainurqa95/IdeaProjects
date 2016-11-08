package models;

import javafx.scene.control.Label;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

/**
 * Created by ainur on 03.11.16.
 */
public abstract class NetworкConnection {

    private Consumer<Serializable> onReceiveCallBack;

    private ConnectionThread connThread = new ConnectionThread();
    private Label label;
    protected abstract boolean isServer ();
    protected abstract String getIP();
    protected abstract int getPort();


    public NetworкConnection(Consumer<Serializable> onReceiveCallBack) {
        this.onReceiveCallBack = onReceiveCallBack;
        connThread.setDaemon(true);
    }
    public void startConnection(){
        connThread.start();
    }
    public void send(Serializable data) throws IOException {
        connThread.out.writeObject(data);

    }
    public void closeConnection () throws IOException {
        connThread.socket.close();
    }

    private class ConnectionThread extends Thread {
        private  Socket socket;
        private ObjectOutputStream out;
        @Override
        public void run() {
            try {
                ServerSocket server = isServer() ?  new ServerSocket(getPort()): null;
                Socket socket = isServer() ? server.accept() : new Socket(getIP(),getPort());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                this.out = out;
                this.socket = socket;
                socket.setTcpNoDelay(true);
                while (true){

                    Serializable data = (Serializable) in.readObject();
                    onReceiveCallBack.accept(data);

                }
            } catch (IOException e) {
                e.printStackTrace();
                onReceiveCallBack.accept("Connection closed");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
