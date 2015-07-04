class InvalidHoursException extends Exception
{

}
class NegativeHoursException extends InvalidHoursException
{

}
class ZeroHoursException extends InvalidHoursException
{

}
class Light
{
    protected String billType = "Small bill";
    protected double getBill(int noOfHours) throws InvalidHoursException
    {
        if(noOfHours < 0)
            throw new NegativeHoursException();
        double smallAmount = 10.0, smallBill = smallAmount * noOfHours;
        System.out.println(billType +": Light: "+ smallBill);
        return smallBill;
    }
    public static void printBillType()
    {
        System.out.println("Small bill");
    }
    public void banner()
    {
        System.out.println("Let there be light!");
    }
}
class TubeLight extends Light
{
    public static String billType = "Large bill";
    public double getBill(final int noOfHours) throws ZeroHoursException
    {
        if(noOfHours == 0)
            throw new ZeroHoursException();
        double largeAmount = 100.0,largeBill = largeAmount * noOfHours;
        System.out.println(billType + ": TubeLight: "+ largeBill);
        return largeBill;
    }
    public static void printBillType()
    {
        System.out.println(billType);
    }
    public double getBill()
    {
        System.out.println("No bill");
        return 0.0;
    }
}
class NeonLight extends TubeLight
{
    public void demonstrate() throws InvalidHoursException
    {
        super.banner();
        super.getBill();
        super.getBill(20);
        ((Light)this).getBill(20);
        System.out.println(super.billType);
        System.out.println(((Light)this).billType);
        super.printBillType();
        ((Light)this).printBillType();
    }
}
public class Client
{
    public static void main(String[] args) throws InvalidHoursException
    {
        NeonLight neonRef = new NeonLight();
        neonRef.demonstrate();
    }
}