/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple.minds;

import java.net.Socket;
import java.io.*;
import java.net.*;

/**
 * @author Akram Kasem
 *
 */
public class Client {

    Socket socketConnection;
    DataOutputStream outToServer;
    DataInputStream din;

    public Client(String name, int Score, String Pass) throws UnknownHostException, IOException {

        socketConnection = new Socket("127.0.0.1", 8000);
        outToServer = new DataOutputStream(socketConnection.getOutputStream());
        din = new DataInputStream(socketConnection.getInputStream());

        String ClientName = null;
        try {
            ClientName = name;
            ClientName += ":";

            outToServer.writeUTF(ClientName + Score + ":" + Pass);
            outToServer.flush();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
