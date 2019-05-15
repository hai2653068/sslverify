package com.mxs.sslverify;


public class SslVerifyUtilTest {


    @org.junit.Test
    public void verify() {
        try{
            //String keyPath = "D:/cert/2199640_form.126net.cn.key";
            String keyPath = "D:/cert/2199672_csc.126net.com.key";
            String pemPath = "D:/cert/2199640_form.126net.cn.pem";
            SslVerifyUtil.verify(keyPath,pemPath);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
