package co.edu.uniquindio.ahorcado.Model;

import co.edu.uniquindio.ahorcado.Controllers.CostumerViewController;

import java.io.DataInputStream;
import java.io.IOException;

public class CostumerThread extends Thread {
    private int id;
    private final DataInputStream dis;
    private String word;
    private final Costumer costumer;

    public CostumerThread(DataInputStream dis, Costumer costumer) {
        this.dis = dis;
        this.costumer = costumer;
    }

    @Override
    public synchronized void run() {
        try{
            while (true) {
                word = dis.readUTF();
                costumer.setWord(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
