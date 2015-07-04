package com.nandan.stratagy;
public abstract class Duck
{
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void performQuack()
    {
        quackBehavior.quack();
    }
    public void performFly()
    {
        flyBehavior.fly();
    }
    public abstract void display();
    public void setFlyBehavior(FlyBehavior fb)
    {
        flyBehavior = fb;
    }
    public void setQuackBehavior(QuackBehavior qb)
    {
        quackBehavior = qb;
    }
    public void swim()
    {
        System.out.println("All ducks float, even decoys!");
    }
}