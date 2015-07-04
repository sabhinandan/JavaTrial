/**
 * FibonacciService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package fibonacci.ws;

public interface FibonacciService extends javax.xml.rpc.Service {
    public java.lang.String getfibonacciAddress();

    public fibonacci.ws.Fibonacci getfibonacci() throws javax.xml.rpc.ServiceException;

    public fibonacci.ws.Fibonacci getfibonacci(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
