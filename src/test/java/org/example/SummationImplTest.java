package org.example;

import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class SummationImplTest {

    @Test
    void testSum() throws RemoteException {

        SummationImpl summation = new SummationImpl();

        assertEquals(5, summation.sum(2, 3));
        assertEquals(0, summation.sum(2, -2));
        assertEquals(10, summation.runningSum("1,2,3,4"));
    }

    @Test
    void testSumCrossesMaxValue() {

        SummationImpl summation = new SummationImpl();
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> summation.sum(Integer.MAX_VALUE, Integer.MAX_VALUE));

        assertEquals("addition crosses the max value of Integers", exception.getMessage());
    }

    @Test
    void testException() {

        SummationImpl summation = new SummationImpl();
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> summation.runningSum("1,2,3,a,4"));

        assertEquals("For input string: \"a\"", exception.getMessage());
    }
}