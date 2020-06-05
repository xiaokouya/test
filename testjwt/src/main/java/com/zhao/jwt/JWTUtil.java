package com.zhao.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zhao.util.DateUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {

    public void test() {
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        Algorithm algorithm = Algorithm.HMAC256("secret");

        JWT.create().withHeader(map)
                .withIssuer("SERVICE")
                .withSubject("this is test token")
                .withAudience("APP")
                .withIssuedAt(new Date())
                .withExpiresAt(DateUtils.parseDate("2020-06-06 13:23:56"))
                .sign(algorithm);
    }

    public void createToken() {
        String secret = "secret";
//        构建秘钥信息
        Algorithm algorithm = Algorithm.HMAC256("secret");

        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        String token = JWT.create()
                .withHeader(map)// 设置头部信息 Header
                .withIssuer("SERVICE")//设置 载荷 签名是有谁生成 例如 服务器
                .withSubject("this is test token")//设置 载荷 签名的主题
//                 .withNotBefore(new Date())//设置 载荷 定义在什么时间之前，该jwt都是不可用的.
                .withAudience("APP")//设置 载荷 签名的观众 也可以理解谁接受签名的
                .withIssuedAt(new Date()) //设置 载荷 生成签名的时间
                .withExpiresAt(DateUtils.parseDate("2020-06-06 13:23:56"))//设置 载荷 签名过期的时间
                .sign(algorithm);//签名 Signature

    }
}