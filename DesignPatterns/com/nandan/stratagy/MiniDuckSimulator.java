//package com.nandan.stratagy;

import com.nandan.stratagy.*;
import com.nandan.stratagy.Duck;
import com.nandan.stratagy.MallardDuck;
import com.nandan.stratagy.ModelDuck;
import com.nandan.stratagy.FlyRocketPowered;

public class MiniDuckSimulator
{
    public static void main(String[] args)
    {
        System.out.println("Hello ");

        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model  = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();


    }
}