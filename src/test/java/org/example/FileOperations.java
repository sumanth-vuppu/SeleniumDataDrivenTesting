package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class FileOperations {

    public static void main(String[] args) throws IOException {
       boolean isFileFound=false;
        File file= new File("C:\\Users\\sumanth\\Downloads");
       File[] fileNames= file.listFiles();

       for(int i=0;i<fileNames.length;i++){
           System.out.println(fileNames[i]);
           if(fileNames[i].toString().contains("xdm-setup.msi")){
               isFileFound=true;
               break;
           }

       }

       if(isFileFound){
           System.out.println("file found");
       }else {
           throw  new FileNotFoundException("File not found please check again");
       }

        FileInputStream fileInputStream=new FileInputStream(file+"\\samplefile.txt");
int c;
       while ((c= fileInputStream.read())!=-1){


System.out.print((char) c);

}
fileInputStream.close();
    }
}
