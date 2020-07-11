package Logic;

import Interface.JTableGui;

/**
 * This is MergeByParts class, it merges a file splitted in parts. Since the are very similar classes
 * it inherits from {@link MergeByKb} and uses the same methods, the only difference is the extension
 */
public class MergeByParts extends MergeByKb implements Runnable{
    public MergeByParts(String fileName, String path, JTableGui tableGui,String extension,int numSplits,int rowCount) {
        super(fileName,path,tableGui,extension,numSplits,rowCount);
    }

    public void run(){
        super.run();
    }

}
