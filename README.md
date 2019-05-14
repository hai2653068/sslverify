# sslverify

需求：客户上传nginx SSL证书，通过模版生成Nginx 配置文件, 证书需要进行校验证书是否有效，并获取证书信息。

方案：使用 org.bouncycastle 进行读取文件内容，比较公用key

        <dependency>
            <groupId>org.bouncycastle</groupId>
            <artifactId>bcprov-jdk16</artifactId>
            <version>1.45</version>
        </dependency>
