package Logic;

import java.io.*;

public class SplitInParts{


    private String path;
    private int fileChunks;
    private int partsDim;
    private int lastPartDim;
    private int lastIndex;
    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private File file;

    public SplitInParts(String path,int fileChunks){

        this.path=path;
        this.fileChunks=fileChunks;
    }

    public void splitFileInParts(){
        try {
            file=new File(path);
            partsDim=Math.toIntExact(file.length()/fileChunks);
            lastPartDim=Math.toIntExact(file.length()%fileChunks);
            byte[] buff=new byte[partsDim];
            inputStream=new FileInputStream(file);
            for(int i=0;i<fileChunks-1;i++){
                inputStream.read(buff);
                outputStream=new FileOutputStream(file.getName() + (i+1) + ".InParts");
                outputStream.write(buff);
                lastIndex=i+2;
            }

            outputStream=new FileOutputStream(file.getName() + lastIndex + ".InParts");
            outputStream.write(new byte[lastPartDim+partsDim]);
            inputStream.close();
        }
        catch (Exception e){

        }
    }


}
