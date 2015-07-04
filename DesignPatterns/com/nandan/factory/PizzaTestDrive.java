import com.nandan.factory.PizzaStore;
import com.nandan.factory.NYPizzaStore;
import com.nandan.factory.ChicagoPizzaStore;
import com.nandan.factory.ChicagoStyleCheesePizza;
import com.nandan.factory.Pizza;
public class PizzaTestDrive
{
    public static void main(String[] args)
    {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a "+ pizza.getName() +"\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a "+ pizza.getName() +"\n");
    }
}