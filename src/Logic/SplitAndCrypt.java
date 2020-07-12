package Logic;

import Interface.JTableGui;
import javax.crypto.Cipher;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * This is SplitAndCrypt class, it splits a file based on the users input kb and it also encrypts the output files
 */
public class SplitAndCrypt implements Runnable{
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
    JTableGui jTableGui;
    private int rowCount;
    private int percentage;

    /**
     * This is the class constructor
     * @param path input file path
     * @param password used to encrypt il file
     * @param partsDim the dimension of every single output file
     * @param rowCount the index of the table's row
     * @param tableGui the table from {@link JTableGui}
     */
    public SplitAndCrypt(String path,String password,int partsDim,int rowCount,JTableGui tableGui){
        this.partsDim=partsDim;
        this.path=path;
        generateCipher=new GenerateCipher(password,true);
        this.jTableGui=tableGui;
        this.rowCount=rowCount;
    }

    /**
     * This is the run method, it splits a file in parts based on the users input. The users tells the dimension
     * of the split. The program reads a split and writes it in a new file. Every time a byte is read, it is then
     * ciphered and written in a new file.
     */
    public void run(){
        try{
            cipher=generateCipher.getCipher();
            file = new File(path);
            partsDim=partsDim*1024;
            lastPartDim = Math.toIntExact(file.length() % partsDim);
            fileChunks = Math.toIntExact(file.length() / partsDim);
            byte[] buff = new byte[partsDim];
            inputStream = new FileInputStream(file);
            for(int j=1;j<=fileChunks;j++){
                inputStream.read(buff);
                outputStream=new FileOutputStream(file.getName() + j + ".crypt" );
                byte[] cipheredByte=cipher.update(buff);
                outputStream.write(cipheredByte);
                outputStream.close();
                lastIndex =j;
                try{
                    Thread.sleep(300);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                percentage=(j*100)/fileChunks;
                jTableGui.setValue(percentage + "%",rowCount);
            }
            outputStream=new FileOutputStream(file.getName() + (lastIndex+1) + ".crypt" );
            byte[] lastBuff=new byte[lastPartDim];
            byte[] lastCipheredByte=cipher.update(lastBuff);
            outputStream.write(lastCipheredByte);
            inputStream.close();
            outputStream.close();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    };
}
