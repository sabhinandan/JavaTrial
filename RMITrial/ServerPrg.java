import java.rmi.*;
import java.rmi.server.*;
interface I extends Remote
{
 int add(int i, int j) throws RemoteException   ;

}
public class ServerPrg extends UnicastRemoteObject implements I
{
 public ServerPrg() throws RemoteException
 {

 }
 public int add(int i, int j) throws RemoteException
 {
     return i+j;
 }
}