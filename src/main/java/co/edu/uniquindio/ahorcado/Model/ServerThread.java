package co.edu.uniquindio.ahorcado.Model;

import co.edu.uniquindio.ahorcado.Controllers.ServerViewController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

public class ServerThread extends Thread implements Observable{
    private final int id;
    private final Socket socket;
    private final DataInputStream dis;
    private final DataOutputStream dos;
    private final Game game;

    private final LinkedList<Observer> observers;
    private final ServerViewController serverViewController;

    public ServerThread(int id, Socket socket, Game game, ServerViewController serverViewController) throws IOException {
        this.id = id;
        this.socket = socket;
        this.dis = new DataInputStream(socket.getInputStream());
        this.dos = new DataOutputStream(socket.getOutputStream());
        this.game = game;

        this.observers = new LinkedList<>();
        this.serverViewController = serverViewController;

        addObserver(serverViewController);

    }

    @Override
    public synchronized void run() {
        try {
            while (true) {
                char letter = dis.readUTF().charAt(0);
                serverViewController.setLastCharacter(letter);
                System.out.println(letter);
                boolean b = game.addLetter(letter);
                dos.writeBoolean(b);
                notifyObservers(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeSocket();
        }
    }

    //Cerrar las conexiones
    private void closeSocket() {
        try{
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(boolean correct) {
        for (Observer o : observers) {
            o.update(correct);
        }
    }
}