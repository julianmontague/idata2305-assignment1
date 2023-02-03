/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package no.ntnu.idata2305.juliangm.assignment1.utils;

/**
 *
 * @author julian
 */
public class ResponseGenerator {

    public static String generatorResponseHTML(long time1, long time2) {
        return ("<html><body>"
                + "Singlethreaded Server: "
                + time1 + " - " + time2
                + "</body></html>");
    }

    public static String generatorResponseHeader() {
        return ("HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html; charset=UTF-8\r\n"
                + "\r\n\r\n");
    }
}
