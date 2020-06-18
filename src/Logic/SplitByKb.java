package Logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class SplitByKb extends Split{

    private String path;
    private File file;
    private int partsDim;
    private int lastPartDim;
    private int fileChunks;
    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private int lastIndex;

    public SplitByKb(String path,int partsDim){
        this.partsDim=partsDim;
        this.path=path;

    }

    public void splitFileByKb() {

        try{
            file = new File(path);
            lastPartDim = Math.toIntExact(file.length() % partsDim);
            fileChunks = Math.toIntExact(file.length() / partsDim);
            byte[] buff = new byte[partsDim];
            inputStream = new FileInputStream(file);
            for(int j=0;j<fileChunks;j++){
                if(fileChunks>50){
                    break;
                }
                inputStream.read(buff);
                outputStream=new FileOutputStream(file.getName() + (j+1) + ".eqpar");
                outputStream.write(buff);
                lastIndex =j;
            }
            outputStream=new FileOutputStream(file.getName() + (lastIndex +2) + ".eqpar");
            outputStream.write(new byte[lastPartDim]);
            inputStream.close();
        }

        catch (Exception e){

        }
    }
}
