package com.joyin.utils;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;

import org.junit.Test;

public class EncryptTool extends DruidDataSource {

    @Override
    public void setUsername(String username){
        try {
            ConfigTools.decrypt(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.setUsername(username);
    }

    @Override
    public void setPassword(String password){
        try {
            ConfigTools.decrypt(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.setPassword(password);
    }

    @Test
    public void test() throws Exception{
        String username = "root";
        String password = "1234abcd";
        username = ConfigTools.encrypt(username);
        password = ConfigTools.encrypt(password);
        System.out.println("username:" + username + "\n" +"password:" + password);

        username = ConfigTools.decrypt(username);
        password = ConfigTools.decrypt(password);
        System.out.println("username:" + username + "\n" +"password:" + password);
    }
}
