package Logic;

import java.io.*;

public class MergeByKb {
    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private File file;
    private File deletion;

    public MergeByKb(){
    }

    public void mergeFile(String fileName,String path,String genericPath){
        try{
            file=new File(path);
            int i=2;
            outputStream=new FileOutputStream(fileName);
            while(file.exists()){
                inputStream=new FileInputStream(file);
                byte[] buff=new byte[inputStream.available()];
                inputStream.read(buff);
                outputStream.write(buff);
                inputStream.close();

                file.delete();
                file=new File(genericPath + i);
                i++;
            }
            outputStream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
