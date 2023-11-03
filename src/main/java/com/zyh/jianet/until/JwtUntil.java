package com.zyh.jianet.until;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUntil {
    final static String KEY="fd51c4d3b4fa4715b2620e373cd2b4d1";
    /**
     * 生成Jwt
     * @param claims 保存的内容
     * @return jwt令牌
     */
    public static String generateJwt(String claims) {
        return Jwts.builder()
                .claim("number",claims)
                .signWith(SignatureAlgorithm.HS256, KEY)
                .setExpiration(new Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 *1000L))
                .compact();
    }
    /**
     * 解析jwt令牌
     * @param jwt jwt令牌
     * @return 保存的内容
     */
    public static Claims parseJWT(String jwt) {
        return Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
