import java.lang.reflect.*;
public class ClassObject
{
    int intClassVar;
    String str = "ClassString";
    public static void main(String[] args)
    {
        ClassObject classObject = new ClassObject();
        Field[] f = new Field[5];
        Class c = classObject.getClass();
        f = c.getDeclaredFields();
        for(int i=0;i<f.length;i++)
            System.out.println(f[i].getName());

        System.out.println(c.getName());

    }
}