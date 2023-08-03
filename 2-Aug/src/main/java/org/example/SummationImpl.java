package org.example;

import java.rmi.RemoteException;
import java.util.Arrays;

public class SummationImpl implements Summation {

    int persistentSum = 0;

    @Override
    public int sum(int a, int b) throws RemoteException {
        if ((long) a + (long) b > Integer.MAX_VALUE) {
            throw new NumberFormatException("addition crosses the max value of Integers");
        }
        return a+b;
    }

    @Override
    public int runningSum(String str) throws RemoteException {
        String[] split = str.split(",");
        int[] result = {0};
        Arrays.stream(split).forEach(i -> result[0] += (Integer.parseInt(i)));
        return result[0];
    }

    @Override
    public int persistentSum(int a) throws RemoteException
    {
        return persistentSum + a;
    }
}
