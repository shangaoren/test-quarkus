package xyz.owlie.acme.util;

import io.quarkus.elytron.security.common.BcryptUtil;

public class Password {
    public static String hash(String password){
        return BcryptUtil.bcryptHash(password);
    }

    public static boolean verify(String password, String hash){
        return BcryptUtil.matches(password, hash);
    }
}
