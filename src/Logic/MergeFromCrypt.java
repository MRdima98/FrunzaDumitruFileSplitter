package Logic;

import Interface.JTableGui;

import javax.crypto.Cipher;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/**
 * This is the MergeFromCrypt class, it merges and decrypts a splitted file
 */
public class MergeFromCrypt implements Runnable{
    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private File file;
    private Cipher cipher;
    GenerateCipher generateCipher;
    private String fileName;
    private String path;
    private String extension;
    private int rowCount;
    private int numSplits;
    JTableGui tableGui;
    private int percentage;

    /**
     * This is the class constructor
     * @param password the password used for decryption
     * @param fileName the name of the output file
     * @param path the path of the input file which is the first split
     * @param tableGui the JTable from {@link JTableGui}
     * @param extension the extension of the file, in this case crypt
     * @param numSplits the number of parts
     * @param rowCount the index of the table's row
     */
    public MergeFromCrypt(String password,String fileName,String path,JTableGui tableGui,String extension,int numSplits,int rowCount){
        generateCipher=new GenerateCipher(password,false);
        this.fileName=fileName;
        this.path=path;
        this.tableGui=tableGui;
        this.extension=extension;
        this.numSplits=numSplits;
        this.rowCount=rowCount;
    }

    /**
     * This is the decryptAndMerge method it decrypts a splitted file, it also shows the progress of the merging
     */
    public void run(){
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
                file=new File(path=path.substring(0,path.indexOf(extension)-2) + i + "." + extension);
                try{
                    Thread.sleep(300);
                }
                catch (InterruptedException e){

                }
                percentage=((i-1)*100)/numSplits;
                tableGui.setValue(percentage + "%",rowCount);
                i++;
            }
            outputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
