package no.ntnu.idata2305.juliangm.assignment1.servers;

import no.ntnu.idata2305.juliangm.assignment1.computation.AsyncSearchSimulator;
import no.ntnu.idata2305.juliangm.assignment1.computation.SearchSimulator;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer implements Runnable {

    /*
     * The server port
     */
    protected int serverPort = 8080;

    /*
     * Initiates the server socket
     */
    protected ServerSocket serverSocket = null;

    /*
     * A boolean flag to indicate if the server is stopped
     */
    protected boolean isStopped = false;

    /*
     * Default constructor
     */
    public MultiThreadedServer(int port) {
        this.serverPort = port;
    }

    /*
     * The run method of the server
     */
    public void run() {
        // open the server socket
        openServerSocket();

        // while the server is not stopped
        while (!isStopped()) {
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // wait for a connection
            // on receiving a request, execute the heavy computation
            new Thread(
                    new AsyncSearchSimulator(
                            clientSocket,
                            "Multithreaded Server"
                    )
            ).start();
            try {
                // accept the client connection
                // create a new thread to handle the request
                OutputStream outputStream = clientSocket.getOutputStream();
                // execute the heavy computation
                outputStream.write(SearchSimulator.processClientRequest().getBytes());
                // flush the output stream
                outputStream.flush();
                // close the client socket
                clientSocket.close();

            } catch (Exception e) {
                // throw a runtime exception
                throw new RuntimeException(e + "Error accepting client connection");
            }
        }

        System.out.println("Server Stopped.");
    }

    /*
     * A method to check if the server is stopped
     */
    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    /*
     * A method to stop the server, synchronized to avoid race conditions.
     * synchronized keyword is used to lock an object for any shared resource.
     */
    public synchronized void stop() {
        this.isStopped = true;
    }

    /*
     * A method to open the server socket
     */
    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}