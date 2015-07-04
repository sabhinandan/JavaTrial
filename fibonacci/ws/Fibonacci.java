/**
 * Fibonacci.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package fibonacci.ws;

public interface Fibonacci extends java.rmi.Remote {
    public int calculateFibonacci(int in0) throws java.rmi.RemoteException;
    public int[] calculateFibonacciRange(int in0, int in1) throws java.rmi.RemoteException;
}
