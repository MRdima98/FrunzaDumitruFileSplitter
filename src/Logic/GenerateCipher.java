package Logic;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

/**
 * This is GenerateCipher a class that generates the crypt and decrypt cipher
 */
public class GenerateCipher {
    private Cipher cipher;
    private byte[] salt1;
    private byte[] salt2;

    /**
     * This is GenerateCipher the class constructor, it generates the cipher
     * @param password the input password to generate the cipher
     * @param crypt a boolean used to know if we are encrypting or decrypting
     */
    public GenerateCipher (String password, boolean crypt){
        try{
            this.cipher=makeCipher(password,crypt);
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | InvalidKeySpecException e){
            e.printStackTrace();
        }
    }

    /**
     * This is generateSalts a method that generates my salts
     * @param password the input password used to generate the salts
     */
    public void generateSalts(String password){
        byte[] pass_bytes=password.getBytes();
        salt1=new byte[8];
        for(int i=0;i<pass_bytes.length;i++){
            salt1[i]=pass_bytes[i];
        }
        if(pass_bytes.length<8){
            for(int i=pass_bytes.length; i<8; i++){
                salt1[i]=(byte) 0x00;
            }
        }
        salt2=new byte[16];
        for(int i=0; i<pass_bytes.length; i++){
            salt2[i]=pass_bytes[i];
        }
        if(pass_bytes.length<16){
            for(int i=pass_bytes.length; i<16; i++){
                salt2[i]=(byte) 0x00;
            }
        }
    }

    /**
     * This is the makeCipher method, it generates and returns the cipher
     * @param password the input password used to generate the cipher
     * @param crypt boolean used to recognize if we are encrypting or decrypting
     * @return returns
     */
    public Cipher makeCipher(String password, boolean crypt) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, InvalidKeySpecException {
        generateSalts(password);
        KeySpec keySpec=new PBEKeySpec(password.toCharArray(),salt1,65535,256);
        SecretKeyFactory secretKeyFactory=SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        SecretKey secretKey=secretKeyFactory.generateSecret(keySpec);
        Cipher tmpCipher=Cipher.getInstance("AES/CFB8/NoPadding");
        IvParameterSpec iv=new IvParameterSpec(salt2);
        SecretKey aesKey=new SecretKeySpec(secretKey.getEncoded(),"AES");
        if(crypt)
            tmpCipher.init(Cipher.ENCRYPT_MODE,aesKey,iv);
        else
            tmpCipher.init(Cipher.DECRYPT_MODE,aesKey,iv);
        return  tmpCipher;
    }

    /**
     * This class returns the cipher
     * @return the cipher
     */
    public  Cipher getCipher(){
        return cipher;
    }
}
