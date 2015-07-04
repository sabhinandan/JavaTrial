class A implements Runnable
      {
          public void run()
          {
              for(int i=0;i<10;i++)
                {
                   System.out.println("Class A"+i);
                }

          }
      }
class B implements Runnable
      {
          public void run()
          {
              for(int i=0;i<10;i++)
                {
                   System.out.println("Class B");
                }

          }
      }
class ThreadRND
      {
            public static void main(String args[])
            {
               A a = new A();
               B b = new B();
               System.out.println("Main Method started.");
               Thread t = new Thread(a);
               t.setDaemon(true);
               t.start();
/*            try{
               t.sleep(1);
               }
            catch(Exception e) {  }
*/
               System.out.println("Main Thread Ends");
            }
      }