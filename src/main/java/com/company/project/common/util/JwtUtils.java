package com.company.project.common.util;

import com.company.project.manage.entity.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * jwt工具类
 */
@Slf4j
@Data
public class JwtUtils {

    //发行者
    public static final String SUBJECT="raychen";
    //过期时间 一天
    public static final long EXPIRE=24*60*60*1000;
    //密钥
    public static final String APP_SECRET ="raychen11";

    /**
     * 生成jwt
     */
    public static String generateToken(UserInfo user){
        if(user==null || user.getId()==null || user.getUsername()==null || user.getPassword()==null){
            return null;
        }

        return Jwts.builder().setSubject(SUBJECT)
                .claim("id",user.getId())
                .claim("name",user.getUsername())
                .claim("password",user.getPassword())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APP_SECRET).compact();
    }

    /**
     * 校验token 用户信息可在claims中获取
     */
    public static Claims checkToken(String token){
        //仿造的token或者已过期就会报错
        try {
            return Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody();
        }catch (Exception e){
            System.out.println("catch...");
        }
        return null;
    }

}
