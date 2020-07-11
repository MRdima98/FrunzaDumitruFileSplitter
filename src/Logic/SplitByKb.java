package Logic;

import Interface.JTableGui;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class SplitByKb implements Runnable{

    private String path;
    private File file;
    private int partsDim;
    private int lastPartDim;
    private int fileChunks;
    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private int lastIndex;
    JTableGui tableGui;
    private int percentage;
    private int rowCount;

    public SplitByKb(String path, int partsDim,int rowCount, JTableGui tableGui) {
        this.partsDim = partsDim;
        this.path = path;
        this.tableGui=tableGui;
        this.rowCount=rowCount;
    }

    public void run() {
        try{
            file = new File(path);
            partsDim=partsDim*1024;
            lastPartDim = Math.toIntExact(file.length() % partsDim);
            fileChunks = Math.toIntExact(file.length() / partsDim);
            byte[] buff = new byte[partsDim];
            inputStream = new FileInputStream(file);
            for(int j=1;j<=fileChunks;j++){
                inputStream.read(buff);
                outputStream=new FileOutputStream(file.getName() + j + ".eqpar");
                outputStream.write(buff);
                outputStream.close();
                lastIndex =j;
                try{
                    Thread.sleep(300);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                percentage=(j*100)/fileChunks;
                tableGui.setValue(percentage + "%",rowCount);
            }
            outputStream=new FileOutputStream(file.getName()  + (lastIndex +1) + ".eqpar");
            byte[] lastBuff=new byte[lastPartDim];
            inputStream.read(lastBuff);
            outputStream.write(lastBuff);
            inputStream.close();
            outputStream.close();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    };

}
