
package org.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

   private Client() {}

   public static void main(String[] args) {

      try {  
         Registry registry = LocateRegistry.getRegistry(null);
    
         Summation stub = (Summation) registry.lookup("Summation");

         int result = stub.sum(1, 2);
         System.out.println("SUM: " + result);

         Scanner sc = new Scanner(System.in);
         while (true) {
            System.out.println("SUM: " + stub.persistentSum(sc.nextInt()));
         }
         
      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}