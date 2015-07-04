//package com.nandan.command;
import com.nandan.command.*;
import com.nandan.command.SimpleRemoteControl;
import com.nandan.command.Light;
import com.nandan.command.LightOnCommand;
import com.nandan.command.GarageDoor;
import com.nandan.command.GarageDoorOpenCommand;
public class RemoteControlTest
{
    public static void main(String[] args)
    {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);
        LightOnCommand lightOn = new LightOnCommand(light);
        remote.setCommand(lightOn);
        remote.buttonWasPressed();

        remote.setCommand(garageOpen);
        remote.buttonWasPressed();
    }
}