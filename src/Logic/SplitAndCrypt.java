package Logic;

import javax.crypto.Cipher;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SplitAndCrypt{
    private File file;
    private FileOutputStream outputStream;
    private FileInputStream inputStream;
    private int fileChunks;
    private int partsDim;
    private int lastIndex;
    private int lastPartDim;
    private String path;
    GenerateCipher generateCipher;
    private Cipher cipher;

    public SplitAndCrypt(String path,String password,int partsDim){
        this.partsDim=partsDim;
        this.path=path;
        generateCipher=new GenerateCipher(password,true);
    }

    public void defaultSplitAndCrypt(){
        try{
            cipher=generateCipher.getCipher();
            file = new File(path);
            partsDim=partsDim*1024;
            lastPartDim = Math.toIntExact(file.length() % partsDim);
            fileChunks = Math.toIntExact(file.length() / partsDim);
            byte[] buff = new byte[partsDim];
            inputStream = new FileInputStream(file);
            for(int j=0;j<fileChunks;j++){
                if(fileChunks>50){
                    break;
                }
                inputStream.read(buff);
                outputStream=new FileOutputStream(file.getName() + ".crypt" + (j+1));
                byte[] cipheredByte=cipher.update(buff);
                outputStream.write(cipheredByte);
                lastIndex =j;
            }
            outputStream=new FileOutputStream(file.getName() + ".crypt" + (lastIndex +2));
            byte[] lastBuff=new byte[lastPartDim];
            byte[] lastCipheredByte=cipher.update(lastBuff);
            outputStream.write(lastCipheredByte);
            inputStream.close();
            file.delete();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }
}
