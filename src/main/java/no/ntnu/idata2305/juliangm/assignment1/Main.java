/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package no.ntnu.idata2305.juliangm.assignment1;

import no.ntnu.idata2305.juliangm.assignment1.servers.MultiThreadedServer;
import no.ntnu.idata2305.juliangm.assignment1.servers.SingleThreadedServer;

/**
 *
 * @author julian
 */
public class Main {

    /**
     * To change the port, change the port in the constructor of the MultiThreadedServer class.
     * To switch between single and multithreaded server, change from new Thread(new SingleThreaded(8080)).start();
     * to new Thread(new MultiThreadedServer(8080)).start();
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Thread(new MultiThreadedServer(8080)).start();
    }
    
}
