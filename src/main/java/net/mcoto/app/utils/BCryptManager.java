package net.mcoto.app.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class BCryptManager {

    public static String hashPassword(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public static boolean checkPassword(String password, String hash) {
        return BCrypt.verifyer().verify(password.toCharArray(), hash).verified;
    }
}
