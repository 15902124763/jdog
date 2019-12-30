package com.yarm.jdog.command;

/**
 * @program: jdog
 * @description: 获取git仓库数据
 * @author: yarm.yang
 * @create: 2019-12-30 14:26
 */
public class GitClone extends AbstractCommandFactory{
    private String GIT_URL = "git clone git@github.com:15902124763/jdog.git /home/yarm/temp/code";

    public void get(){
        this.exec(GIT_URL);
    }

    public void gitFetch(){
        this.exec("git fetch");
    }

    public void gitCheckout(){}
}
