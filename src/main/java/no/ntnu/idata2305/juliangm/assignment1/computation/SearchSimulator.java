/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package no.ntnu.idata2305.juliangm.assignment1.computation;

import no.ntnu.idata2305.juliangm.assignment1.utils.ResponseGenerator;

/**
 *
 * @author julian
 */
public class SearchSimulator {

    public static String processClientRequest() throws Exception {
        long time1 = System.currentTimeMillis();
        System.out.println("Request processing started at: " + time1);
        Thread.sleep(10 * 1000);
        long time2 = System.currentTimeMillis();
        System.out.println("Request processing ended at: " + time2);
        return ResponseGenerator.generatorResponseHeader() +
            ResponseGenerator.generatorResponseHTML(time1, time2);
    }
}
