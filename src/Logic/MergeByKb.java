package Logic;

import java.io.*;

public class MergeByKb {

    private String path;
    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private File file;
    private String genericPath;

    public MergeByKb(String path){
        this.path=path;
    }

    public void mergeFile(){
        try{
            file=new File(path);
            int i=2;
            genericPath=deleteLastIndex(path);
            outputStream=new FileOutputStream(fileName(genericPath));
            while(file.exists()){
                inputStream=new FileInputStream(file);
                byte[] buff=new byte[inputStream.available()];
                inputStream.read(buff);
                outputStream.write(buff);
                inputStream.close();
                file=new File(genericPath + i);
                i++;
            }
            outputStream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public String deleteLastIndex(String str){
        if(str!=null & str.length()>0)
            str=str.substring(0,str.length()-1);
        return str;
    }

    public String fileName(String str){
        if(str!=null & str.length()>0)
            str=str.substring(0,str.length()-5);
        return str;
    }
}
