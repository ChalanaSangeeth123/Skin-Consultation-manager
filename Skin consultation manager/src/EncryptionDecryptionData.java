import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

//https://stackoverflow.com/questions/73264061/encrypt-a-field-to-send-to-another-api
public class EncryptionDecryptionData {
    private static SecretKeySpec secretKey;
    private static final String ALGORITHM = "AES";

    public void prepareSecreteKey(String myKey) {
        MessageDigest sha;
        try {
            byte[] key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    public String encrypt(String strToEncrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            String encryptData = Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
            System.out.println("Encrypted Notes: " + encryptData);
            return encryptData;
        } catch (Exception e) {
            System.out.println("Error encrypting: " + e);
        }
        return null;
    }

    public String decrypt(String strToDecrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            String decryptData  = new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
            System.out.println("Decrypted Notes: " + decryptData);
            return decryptData;
        } catch (Exception e) {
            System.out.println("Error decrypting: " + e);
        }
        return null;
    }

}
