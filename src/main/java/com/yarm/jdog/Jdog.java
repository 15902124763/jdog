package com.yarm.jdog;


import com.yarm.jdog.command.GitClone;
import com.yarm.jdog.listen.ConsoleListener;

import java.util.Scanner;

/**
 * @program: jdog
 * @description: main入口
 * @author: yarm.yang
 * @create: 2019-12-30 13:59
 */
public class Jdog {
    public static void main(String[] args) {
        System.out.println("begin");
        System.out.println("begin");
        listen();
        System.out.println("end");
    }

    public static void listen(){

        final GitClone gitClone = new GitClone();

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

        cs.addAction("git clone", new ConsoleListener.Action() {

            public void act(String msg) {
                System.out.println("Console: ...");
                if("git clone".equalsIgnoreCase(msg)){
                    gitClone.get();
                }
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
