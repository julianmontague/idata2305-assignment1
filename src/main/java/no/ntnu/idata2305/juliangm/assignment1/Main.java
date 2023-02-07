/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package no.ntnu.idata2305.juliangm.assignment1;

import no.ntnu.idata2305.juliangm.assignment1.servers.MultiThreadedServer;

/**
 *
 * @author julian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Thread(new MultiThreadedServer(8080)).start();
    }
    
}
