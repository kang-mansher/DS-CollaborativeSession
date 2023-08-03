package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {

    private Server summation;

    @BeforeEach
    public void init() {
        summation = new Server();
    }

    @Test
    public void integrationTest() {
        try {

            Registry registry = LocateRegistry.getRegistry();
            Summation stub = (Summation) registry.lookup("Summation");
            int response = stub.sum(1, 3);
            int expected = 4;
            assertEquals(response, expected);

        } catch (RemoteException e) {
            Assertions.fail("Exception Occurred: " + e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

}
