package appLaunchTwo;

import appLaunchTwo.Classes.Program;
import appLaunchTwo.GUI.FrameExecuting;
import appLaunchTwo.Logic.HandlerProgram;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author BOIKA
 * @version 1.2
 * 08.19.2020, MINSK
 */

public class MainLaunchTwo {
    public static void main(String[] args) throws IOException {
        System.out.println("HI! The Program for to launch Programs!");

        List<Program> programs = new ArrayList<>();

         HandlerProgram handlerProgram = new HandlerProgram(programs);
        int i = 0;
        for (Program it : handlerProgram.getProgramList()) {
             System.out.println("Program "+ (i++) + it);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                   FrameExecuting frameExecuting = new FrameExecuting();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
}
