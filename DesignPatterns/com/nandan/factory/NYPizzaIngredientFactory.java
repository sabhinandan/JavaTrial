package com.nandan.factory;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory
{
    public Dough createDough()
    {
        return new ThinCrustDough();
    }
    public Sauce createSauce()
    {
        return new MarinaraSauce();
    }
    public Chese createCheese()
    {
        return new RegginaoCheese();
    }
    public Veggies[] createVeggies()
    {
        Veggies veggies[] = {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
        return veggies;
    }
    public Pepperoni createPepperoni()
    {
        return new SlicePepperoni();
    }
    public Clams createClam()
    {
        return new FreshClams();
    }
}