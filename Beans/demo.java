/**
 * Demo -- this is the "remote" interface of our Enterprise Java Bean, it
 *         defines only one simple method called demoSelect() which as this is
 *         a stateless simplistic bean example it just returns a string, no
 *         database lookup is even done.
 *
 *  Note: The implementation of this interface is provided by the container tools
 *        but the demoSelect() method and any other methods in this interface
 *        will need to have equivalent implementations in the DemoBean.java
 *        implementation which is supplied by the bean Writer ..i.e. you!
 */

//package ejb.demo;

import java.rmi.RemoteException;
import java.rmi.Remote;

//import javax.ejb.*;




public interface Demo extends EJBObject, Remote {

  // NB this simple example does not even do a lookup in the database
  public String demoSelect() throws RemoteException;

}