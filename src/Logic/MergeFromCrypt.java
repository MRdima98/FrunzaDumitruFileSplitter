package Logic;

import javax.crypto.Cipher;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MergeFromCrypt {

    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private File file;
    private Cipher cipher;
    GenerateCipher generateCipher;

    public MergeFromCrypt(String password){
        generateCipher=new GenerateCipher(password,false);
    }

    public void decryptAndMerge(String fileName,String path,String genericPath){
        try{
            file=new File(path);
            int i=2;
            outputStream=new FileOutputStream(fileName);
            cipher=generateCipher.getCipher();
            while(file.exists()){
                inputStream=new FileInputStream(file);
                byte[] buff=new byte[inputStream.available()];
                inputStream.read(buff);
                byte[] cipheredByte=cipher.update(buff);
                outputStream.write(cipheredByte);
                inputStream.close();
                file.delete();
                file=new File(genericPath + i);
                i++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
