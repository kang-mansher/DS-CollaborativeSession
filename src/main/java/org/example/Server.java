package org.example;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry; 
import java.rmi.server.UnicastRemoteObject;

public class Server extends SummationImpl {

   public Server() {}

   public static void main(String args[]) { 
      try {

         Server server = new Server();

         Summation stub = (Summation) UnicastRemoteObject.exportObject((Summation) server, 0);

         Registry registry = LocateRegistry.createRegistry(1098);
         
         registry.bind("Summation", stub);

         System.err.println("Server ready");

      } catch (Exception e) { 
         System.err.println("Server exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   }

} 