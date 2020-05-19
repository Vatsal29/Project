/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package N.server;

import java.net.SocketException;

/**
 * @author shanks
 */
public class ServerMain {

    private int port;
    private Server server;

    public ServerMain(int port) throws SocketException {
        this.port = port;
        server = new Server(port);
    }

    public static void main(String args[]) throws SocketException {
        int port;


        port = 8192;
        new ServerMain(port);
    }
}
