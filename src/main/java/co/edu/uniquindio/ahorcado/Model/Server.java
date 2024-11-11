package co.edu.uniquindio.ahorcado.Model;

import co.edu.uniquindio.ahorcado.Controllers.ServerViewController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server implements Runnable {
    private Game game;
    private final ServerSocket serverSocket;
    private final LinkedList<Socket> sockets;
    private static int threadCounter = 1;

    private final ServerViewController serverViewController;

    public Server(ServerViewController serverViewController) throws IOException {
        game = new Game();
        serverSocket = new ServerSocket(1234);
        sockets = new LinkedList<>();

        this.serverViewController = serverViewController;
    }

    @Override
    public synchronized void run() {
        try {
            while(true) {
                sockets.add(serverSocket.accept());
                DataInputStream dis = new DataInputStream(sockets.getLast().getInputStream());
                DataOutputStream dos = new DataOutputStream(sockets.getLast().getOutputStream());

                System.out.println("Servidor recibiendo: " + dis.readUTF());
                dos.writeUTF("Conexión establecida.");

                dos.writeUTF(game.getWord());

                new ServerThread(threadCounter, sockets.getLast(), game, serverViewController).start();
                setThreadCounter();
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        } finally {
            closeSockets();
            Thread.currentThread().interrupt();
        }
    }

    public void restartGame() throws IOException {
        game.restartGame();
        for (Socket socket : sockets) {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(game.getWord());
        }
    }

    public void closeSockets() {
        try {
            for (Socket socket : sockets) {
                socket.getOutputStream().close();
                socket.getInputStream().close();
                socket.close();
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public static void setThreadCounter() {
        threadCounter++;
    }

    //Getters
    public Game getGame() {
        return game;
    }
}
