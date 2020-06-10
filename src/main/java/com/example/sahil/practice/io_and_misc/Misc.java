package com.example.sahil.practice.io_and_misc;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Misc {

//=========== Launch external applications through java code ====================
//Write a java program to launch external applications like notepad, MS Word etc.

    // java.lan.Runtime helps launch internal Apps
    public static void launchNotePad() throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process p = runtime.exec("notepad.exe"); //Internal app, so it get the path from env variables
        p.waitFor(10, TimeUnit.SECONDS);
        p.destroy();
        //Third Party app, so have to explicity mention full path
        p = runtime.exec("C:\\Program Files (x86)\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        p.waitFor(10, TimeUnit.SECONDS);
        p.destroy();
    }

}
