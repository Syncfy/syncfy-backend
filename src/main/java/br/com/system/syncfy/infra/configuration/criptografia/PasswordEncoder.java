package br.com.system.syncfy.infra.configuration.criptografia;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class PasswordEncoder {

    public String encode(String pass) {
        MessageDigest algorithm;
        StringBuilder hexPass = new StringBuilder();

        try {
            algorithm = MessageDigest.getInstance("SHA-256");
            byte[] messageDigestPass = algorithm.digest(pass.getBytes(StandardCharsets.UTF_8));

            for (byte b : messageDigestPass) {
                hexPass.append(String.format("%02X", 0xFF & b));
            }

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Não foi possível utilizar o algoritmo SHA-256", e);
        }

        return hexPass.toString();
    }

    public boolean check(String pass, String hash) {
        String encodedPassword = encode(pass);
        return encodedPassword.equals(hash);
    }
}
