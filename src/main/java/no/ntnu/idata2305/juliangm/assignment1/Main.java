/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package no.ntnu.idata2305.juliangm.assignment1;

import no.ntnu.idata2305.juliangm.assignment1.computation.SearchSimulator;

/**
 *
 * @author julian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            SearchSimulator.processClientRequest();
            System.out.println("We're done here!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}
