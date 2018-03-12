/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.ServerSocket;
import java.net.*;
import java.io.*;

/**
 *
 * @author Leonardo Vasconcelos
 */
public class MultiServer {
    
    public static void main(String[] args) throws IOException {
     ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(1234);
            System.err.println("Servidor  inicializado na porta 1234.\nAguardando novas conexões.");
        } catch (IOException e) {
            System.err.println("Impossível escutar na porta 1234.");
            System.exit(-1);
        }

        while (listening) {
            new MultiServerThread(serverSocket.accept()).start();
        }

        serverSocket.close();   
    }      
    
    
    public void run() throws IOException {
             ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(1094);
            System.err.println("Servidor GDS v0.9 inicializado na porta 1094.\nAguardando novas conexões.");
        } catch (IOException e) {
            System.err.println("Impossível escutar na porta 1094.");
            System.exit(-1);
        }

        while (listening) {
            new MultiServerThread(serverSocket.accept()).start();
        }

        serverSocket.close();    

    }
    
}
