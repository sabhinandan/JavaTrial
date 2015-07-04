package com.nandan.factory;

public interface PizzaIngredientFactory
{
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni create Pepperoni();
    public Clams createClam();
}