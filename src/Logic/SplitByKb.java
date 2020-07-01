package Logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class SplitByKb{

    private String path;
    private File file;
    private int partsDim;
    private int lastPartDim;
    private int fileChunks;
    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private int lastIndex;
    private int fileLenght;

    public SplitByKb(String path,int partsDim){
        this.partsDim=partsDim;
        this.path=path;

    }

    public void splitFileByKb() {

        try{
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
                outputStream=new FileOutputStream(file.getName() + ".eqpar" + (j+1));
                outputStream.write(buff);
                lastIndex =j;
            }
            outputStream=new FileOutputStream(file.getName() + ".eqpar" + (lastIndex +2));
            byte[] lastBuff=new byte[lastPartDim];
            inputStream.read(lastBuff);
            outputStream.write(lastBuff);
            inputStream.close();
            outputStream.close();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }
}
