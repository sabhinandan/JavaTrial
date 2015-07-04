import java.util.*;
class ArrayListRnd
{
    public static void main(String[] args)
    {
        ArrayList arrayList = new ArrayList();
        for(int i=0;i<10;i++)
        {
            arrayList.add(new car());
        }
        Iterator it = arrayList.iterator();
        while(it.hasNext())
        {
             System.out.println((car)it.next());
        }
    }
}
class car
{
    int fuelCapacity;
    String color;
    car()
    {
        fuelCapacity=50;
        color="black";
    }
    public void setCapacity(int capacity)
    {
        this.fuelCapacity=capacity;
    }
    public int getCapacity()
    {
        return fuelCapacity;
    }
    public void setColor(String color)
    {
        this.color=color;
    }
    public String getColor()
    {
        return color;
    }
    public String toString()
    {
        String str="Fule capacity is "+fuelCapacity;
        return str;
    }
}