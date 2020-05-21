package com.company;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String ip ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Schreiben Sie eine adresse...");
        ip = scanner.nextLine();
        try  {
            InetSocketAddress addre = new InetSocketAddress(ip, 80)  ;
            Socket socket = new Socket();
            socket.connect(addre);
            System.out.println("connected to " + ip);
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output.println("GET / HTTP/1.0\r\n");
            output.println("Host: "+ ip+ "\r\n");
            output.println("\r\n");
            output.flush();

            while (input.readLine() != null) {
                System.out.println(input.readLine());


            }
           } catch (IOException e) {
            e.printStackTrace();
        }
     }
}
