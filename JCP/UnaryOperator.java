class UnaryOperator
{
    public static void main(String args[])
    {
      int x=10;
//      x=x++/x++;
//      x=x/x++;
//      x=x++/x;
      System.out.println(x);
      x=0;
      while(x<10)
      {
          System.out.println( "Hello");
          x=x++;
      }
      System.out.println(x);

    } // end of main function
} // end of the class UnaryOperator