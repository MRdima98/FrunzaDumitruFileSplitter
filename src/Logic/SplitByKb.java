package Logic;


import Interface.JTableGui;
import Interface.SplitAndMergeGui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class SplitByKb extends Split{

    private ArrayList<String> filePathListInKb;
    private File file;
    private int partsDim;
    private int lastPartDim;
    private int fileChunks;
    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private int fileDim;
    private int lastJ;

    SplitAndMergeGui splitAndMergeGui;
    JTableGui T;

    public SplitByKb(){
        T=new JTableGui();
        splitAndMergeGui=new SplitAndMergeGui(T);
        filePathListInKb=splitAndMergeGui.getFilePathListInKb();

    }

    @Override
    public void splitFile() {

        try{
             for(int i=0;i<filePathListInKb.size();i=i+2) {
                 file = new File(filePathListInKb.get(i));
                 partsDim = Integer.parseInt(filePathListInKb.get(i + 1));
                 lastPartDim = Math.toIntExact(file.length() % partsDim);
                 fileChunks = Math.toIntExact(file.length() / partsDim);
                 byte[] buff = new byte[partsDim];
                 inputStream = new FileInputStream(file);
                 fileDim=Math.toIntExact(file.length());
                 /*int j=0;
                 while(fileDim>0) {
                     if (fileChunks > 50) {
                         System.out.println("Anche no");
                         break;
                     }
                     inputStream.read(buff);
                     outputStream=new FileOutputStream("prova" + j);
                     outputStream.write(buff);
                     j++;
                     fileDim=fileDim-partsDim;
                 }
                 */
                 for(int j=0;j<fileChunks;j++){
                     if(fileChunks>50){
                         break;
                     }
                     inputStream.read(buff);
                     outputStream=new FileOutputStream(file.getName() + j);
                     outputStream.write(buff);
                     lastJ=j;
                 }
                 outputStream=new FileOutputStream(file.getName() + (lastJ+1));
                 outputStream.write(new byte[lastPartDim]);
                 inputStream.close();
             }
        }

        catch (Exception e){

        }
    }
}
