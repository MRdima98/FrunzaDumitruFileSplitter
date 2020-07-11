package Logic;

import Interface.JTableGui;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This is MergeByKB a class that merges a file which was split in kb
 */
public class MergeByKb implements Runnable{
    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private File inFile;
    private String fileName;
    private String path;
    JTableGui tableGui;
    private String extension;
    private int percentage;
    private int numSplits;
    private int rowCount;

    /**
     * This is the class constructor
     * @param fileName the name of the output file
     * @param path the path of the input file which is the first split
     * @param tableGui the tableGui from {@link JTableGui}
     * @param extension is the extension of the parts
     * @param numSplits is the number of the parts
     * @param rowCount is the index of the table's row
     */
    public MergeByKb(String fileName,String path,JTableGui tableGui,String extension,int numSplits,int rowCount){
        this.fileName=fileName;
        this.path=path;
        this.tableGui=tableGui;
        this.extension=extension;
        this.numSplits=numSplits;
        this.rowCount=rowCount;
    }

    /**
     * This is the run method, it merges a splitted file, it also shows the progress of the merge
     */
    @Override
    public void run() {
        try{
            inFile =new File(path);
            int i=2;
            outputStream=new FileOutputStream(fileName);
            while(inFile.exists()){
                inputStream=new FileInputStream(inFile);
                byte[] buff=new byte[inputStream.available()];
                inputStream.read(buff);
                outputStream.write(buff);
                inputStream.close();
                inFile =new File(path=path.substring(0,path.indexOf(extension)-2) + i + "." + extension);
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
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
