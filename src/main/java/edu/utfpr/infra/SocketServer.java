package edu.utfpr.infra;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import edu.utfpr.data.useCases.Router;
import edu.utfpr.domain.model.Message;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.JSONObject;

@Service
public class SocketServer extends Thread {
    protected static boolean serverContinue = true;
    protected Socket clientSocket;
    ServerSocket serverSocket = null;

    public SocketServer() {
        try {
            serverSocket = new ServerSocket(10008);
            System.out.println("Connection Socket Created");
            try {
                while (serverContinue) {
                    System.out.println("Waiting for Connection on port 10008");
                    new SocketServer(serverSocket.accept());
                }
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port: 10008.");
            System.exit(1);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                System.err.println("Could not close port: 10008.");
                System.exit(1);
            }
        }
    }

    private SocketServer(Socket clientSoc) {
        clientSocket = clientSoc;
        start();
    }

    public void run() {
        System.out.println("New Communication Thread Started");

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
                    true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                try {
                    System.out.println(inputLine);
                    JSONObject message = new JSONObject(inputLine);
                    String event = message.keys().next();
                    System.out.println(message);
                    Message traitedMessage = new Message(event, message);
                    System.out.println(traitedMessage);
                    Router.route(traitedMessage);

                    out.println(inputLine);

                    if (inputLine.equals("Bye."))
                        break;

                    if (inputLine.equals("End Server."))
                        serverContinue = false;
                } catch(Error e) {
                    System.err.println(e.getMessage());
                }
            }

            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.err.println("Problem with Communication Server");
            System.exit(1);
        }
    }
}

