import java.math.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class PowerServiceServer extends UnicastRemoteObject implements PowerService
{
    public PowerServiceServer() throws RemoteException
    {
        super();
    }
    public BigInteger square (int number) throws RemoteException
    {
        String numrep = String.valueOf(number);
        BigInteger bi = new BigInteger(numrep);

        bi.multiply(bi);
        return bi;
    }
    public BigInteger power ( int num1, int num2) throws RemoteException
    {
        String numrep = String.valueOf(num1);
        BigInteger bi = new BigInteger (numrep);


    	bi = bi.pow(num2);
        return bi;
    }
    public static void main(String[] args) throws Exception
    {
        if(System.getSecurityManager() == null)
            System.setSecurityManager( new RMISecurityManager());

        PowerServiceServer svr = new PowerServiceServer();
        Naming.bind("PowerService", svr);
        System.out.println("Serivce bond...");
    }


}
