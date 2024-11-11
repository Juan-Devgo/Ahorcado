package co.edu.uniquindio.ahorcado.Model;

import co.edu.uniquindio.ahorcado.Controllers.CostumerViewController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

public class Costumer implements Runnable, Observable {
    private final LinkedList<Observer> observers;
    private final Socket socket;
    private final DataInputStream dis;
    private final DataOutputStream dos;
    private String word;
    private final int id;

    private CostumerViewController costumerViewController;

    public Costumer(int id, CostumerViewController costumerViewController) throws IOException {
        this.socket = new Socket("localhost", 1234);
        this.dis = new DataInputStream(socket.getInputStream());
        this.dos = new DataOutputStream(socket.getOutputStream());
        this.observers = new LinkedList<>();
        this.id = id;
        this.costumerViewController = costumerViewController;

        addObserver(costumerViewController);
    }

    @Override
    public synchronized void run() {
        try {
            dos.writeUTF("Intentando establecer conexión.");
            System.out.println("Cliente " + id + " recibiendo: " + dis.readUTF());

            word = dis.readUTF();
            costumerViewController.setWord(word);
        } catch (IOException e) {
            e.fillInStackTrace();
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

    //Enviar letra al servidor
    public void sendletter(char letter) throws IOException {
        dos.writeUTF(String.valueOf(letter));
        boolean b = dis.readBoolean();
        System.out.println(b);
        notifyObservers(b);
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

    //Getters
    public String getWord() {
        return word;
    }

    public int getId() {
        return id;
    }

    //Setters
    public void setWord(String word) {
        this.word = word;
        costumerViewController.setWord(word);
    }
}