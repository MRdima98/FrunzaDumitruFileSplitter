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

public class GenerateCipher {

    private Cipher cipher;
    private byte[] salt1;
    private byte[] salt2;

    public GenerateCipher (String password, boolean crypt){
        try{
            this.cipher=makeCipher(password,crypt);
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | InvalidKeySpecException e){
            e.printStackTrace();
        }
    }


    public void generateSalts(String password){
        byte[] pass_bytes=password.getBytes();
        int l=pass_bytes.length;
        salt1=new byte[8];
        for(int i=0;i<l;i++){
            salt1[i]=pass_bytes[i];
        }
        if(l<8){
            for(int i=l; i<8; i++){
                salt1[i]=(byte) 0x00;
            }
        }
        salt2=new byte[16];
        for(int i=0; i<l; i++){
            salt2[i]=pass_bytes[i];
        }
        if(l<16){
            for(int i=l; i<16; i++){
                salt2[i]=(byte) 0x00;
            }
        }
    }

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

    public  Cipher getCipher(){
        return cipher;
    }
}
