package com.yarm.jdog.test;

import java.util.Scanner;

/**
 * @program: jdog
 * @description:
 * @author: yarm.yang
 * @create: 2019-12-30 14:59
 */
public class App {
    public void runTest(String[] args) {
        ConsoleListener cs = new ConsoleListener(new Scanner(System.in), new ConsoleListener.Action() {

            public void act(String msg) {
                System.out.println("Console: " + msg);
            }
        });
        cs.addAction("stop", new ConsoleListener.Action() {

            public void act(String msg) {
                System.out.println("Console: Bye");
                System.exit(0);
            }
        });
        cs.addAction("stop repeating", new ConsoleListener.Action() {

            public void act(String msg) {
                System.out.println("Console: ...");
            }
        });
        cs.listenInNewThread();

        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
