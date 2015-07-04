public class ObjectRND
{
    String customer = "DEFAULT" ;
    public String getCustomer()
    {
        return customer;
    }

    public static void main(String[] args)
    {
        ObjectRND objectRND = new ObjectRND();
        System.out.println(objectRND.getCustomer());
    }

}