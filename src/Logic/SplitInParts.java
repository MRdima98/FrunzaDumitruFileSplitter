package Logic;

import Interface.JTableGui;

import java.io.*;

public class SplitInParts implements Runnable{


    private String path;
    private int fileChunks;
    private int partsDim;
    private int lastPartDim;
    private int lastIndex;
    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private File file;
    JTableGui jTableGui;
    private int rowCount;
    private int percentage;

    public SplitInParts(String path,int fileChunks,int rowCount,JTableGui jTableGui){
        this.jTableGui=jTableGui;
        this.path=path;
        this.fileChunks=fileChunks;
        this.rowCount=rowCount;
    }

    public void run(){
        try {
            file=new File(path);
            partsDim=Math.toIntExact(file.length()/fileChunks);
            lastPartDim=Math.toIntExact(file.length()%fileChunks);
            byte[] buff=new byte[partsDim];
            inputStream=new FileInputStream(file);
            for(int j=1;j<=fileChunks-1;j++){
                inputStream.read(buff);
                outputStream=new FileOutputStream(file.getName() + j + ".inparts");
                outputStream.write(buff);
                lastIndex=j+1;
                outputStream.close();
                try{
                    Thread.sleep(300);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                percentage=(j*100)/fileChunks;
                jTableGui.setValue(percentage + "% ",rowCount);
            }
            outputStream=new FileOutputStream(file.getName() + lastIndex + ".inparts");
            byte[] lastBuff=new byte[lastPartDim+partsDim];
            inputStream.read(lastBuff);
            outputStream.write(lastBuff);
            inputStream.close();
            outputStream.close();
            jTableGui.setValue("100%",rowCount);
        }
        catch (Exception e){

        }
    };


}
