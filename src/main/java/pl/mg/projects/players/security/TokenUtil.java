package pl.mg.projects.players.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.codec.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TokenUtil {
    public static final String MAGIC_KEY = "BasketballApp";

    public static String createToken(UserDetails userDetails) {
        long expires = System.currentTimeMillis() + 1000L * 60 * 60; // 1 hour
        return userDetails.getUsername() + ":" + expires + ":" + computeSignature(userDetails, expires);
    }

    public static String computeSignature(UserDetails userDetails, long expires) {

        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No MD5 algorithm available!");
        }
        String signatureBuilder = userDetails.getUsername() + ":" +
                expires + ":" +
                userDetails.getPassword() + ":" +
                TokenUtil.MAGIC_KEY;
        return new String(Hex.encode(digest.digest(signatureBuilder.getBytes())));
    }

//    public static String getUserNameFromToken(String authToken) {
//        if (authToken == null) {
//            return null;
//        }
//        String[] parts = authToken.split(":");
//        return parts[0];
//    }
//
//    public static boolean validateToken(String authToken, UserDetails userDetails) {
//        String[] parts = authToken.split(":");
//        long expires = Long.parseLong(parts[1]);
//        String signature = parts[2];
//        String signatureToMatch = computeSignature(userDetails, expires);
//        return expires >= System.currentTimeMillis() && signature.equals(signatureToMatch);
//    }
}