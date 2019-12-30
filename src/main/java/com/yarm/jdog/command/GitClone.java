package com.yarm.jdog.command;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: jdog
 * @description: 获取git仓库数据
 * @author: yarm.yang
 * @create: 2019-12-30 14:26
 */
public class GitClone extends AbstractCommandFactory{
    private String GIT_URL = "git clone git@github.com:15902124763/jdog.git";

    public void get(){
        List<String> cmdList = new ArrayList<String>();
        cmdList.add("cd /home/yarm/temp/code");
        cmdList.add(GIT_URL);
        List<String> strings = this.executeNewFlow(cmdList);
        System.out.println(strings);
    }

    public void gitFetch(){
        this.exec("git fetch");
    }

    public void gitCheckout(){}

    public void toDir(String dir){
    }

    public List<String> executeNewFlow(List<String> commands) {
        List<String> rspList = new ArrayList<String>();
        Runtime run = Runtime.getRuntime();
        try {
            Process proc = run.exec("/bin/bash", null, null);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(proc.getOutputStream())), true);
            for (String line : commands) {
                out.println(line);
            }
            // out.println("cd /home/test");
            // out.println("pwd");
            // out.println("rm -fr /home/proxy.log");
            out.println("exit");// 这个命令必须执行，否则in流不结束。
            String rspLine = "";
            while ((rspLine = in.readLine()) != null) {
                System.out.println(rspLine);
                rspList.add(rspLine);
            }
            proc.waitFor();
            in.close();
            out.close();
            proc.destroy();
        } catch (IOException eio) {
            eio.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return rspList;
    }
}
