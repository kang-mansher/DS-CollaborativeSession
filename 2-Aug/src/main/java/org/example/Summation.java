package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Summation extends Remote {
   int sum(int a, int b) throws RemoteException;
   int runningSum(String str) throws RemoteException;
   int persistentSum(int a) throws RemoteException;
} 