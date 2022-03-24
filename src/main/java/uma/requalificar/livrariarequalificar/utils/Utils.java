package uma.requalificar.livrariarequalificar.utils;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PublicKey;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Utils
{

    public static boolean validateEmail (String email)
    {
    	final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    	
    	Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(email);

            return matcher.matches();
    	
    }
    
    public static boolean validatePassword (String password)
    {
    	final String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
    	
    	Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(password);

            return matcher.matches();
    	
    }
    
    // adaptado a partir de:
    // https://stackoverflow.com/questions/23561104/how-to-encrypt-and-decrypt-string-with-my-passphrase-in-java-pc-not-mobile-plat
    public static String encrypt (String password)
    {
    	try 
        {
            String key = "Bar12345Bar12345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b: encrypted) {
                sb.append((char)b);
            }

            // the encrypted String
            String enc = sb.toString();
            return enc;

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    	
    	return "";

    }
    
    public static String decrypt (String hashedPassword)
    {
    	try 
        {

            String key = "Bar12345Bar12345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            
            // now convert the string to byte array
            // for decryption
            byte[] bb = new byte[hashedPassword.length()];
            for (int i=0; i<hashedPassword.length(); i++) {
                bb[i] = (byte) hashedPassword.charAt(i);
            }

            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(bb));
            return decrypted;

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    	
    	return "";

    }
    
}
