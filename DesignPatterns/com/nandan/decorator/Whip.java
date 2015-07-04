//package com.nandan.decorator;
public class Whip extends CondimentDecorator
{
    Beverage beverage;
    public Whip(Beverage beverage)
    {
        this.beverage = beverage;
    }
    public String getDescription()
    {
        return beverage.getDescription() +" , Whip ";
    }
    public double cost()
    {
        return .40 + beverage.cost();
    }
}