package com.mxs.sslverify;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMReader;

import java.io.*;
import java.security.*;
import java.security.cert.*;
import java.text.SimpleDateFormat;

/**
 * @ClassName SslVerifyUtil
 * @AUTHOR MXS
 * @Date 2019/5/14 16:35
 * @Version 1.0
 **/
public class SslVerifyUtil {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void verify(String keyPath,String pemPath) throws SignatureException, IOException, CertificateException, NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException {


        //获取 -----BEGIN RSA PRIVATE KEY-----
        PEMReader  epmReader = new PEMReader(new FileReader(keyPath));
        Object pairObject = epmReader.readObject();

        PublicKey publicKey = null;
        if (pairObject instanceof KeyPair) {
            KeyPair pair = (KeyPair)pairObject;
            publicKey = pair.getPublic();
        }

        //获取 -----BEGIN CERTIFICATE-----
        PEMReader  reader = new PEMReader(new FileReader(pemPath));
        Object pemObject = reader.readObject();


        if (pemObject instanceof X509Certificate) {
            X509Certificate cert = (X509Certificate)pemObject;

            PublicKey publicKey1 = cert.getPublicKey();

            if(publicKey1.equals(publicKey)){
                System.out.println("true");
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            System.out.println("域名信息："+cert.getSubjectDN());
            System.out.println("证书申请时间："+sdf.format(cert.getNotBefore()));
            System.out.println("证书到期时间："+sdf.format(cert.getNotAfter()));


            System.out.println("IssuerDN："+cert.getIssuerDN().getName());
            System.out.println("证书信息："+cert);

        }

    }

}
