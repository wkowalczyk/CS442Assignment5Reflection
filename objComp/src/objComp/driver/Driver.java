package objComp.driver;

import objComp.util.Logger;
import objComp.fileOperations.FileProcessor;
import objComp.util.PopulateObjects;
import objComp.util.First;
import objComp.util.Second;
import objComp.fileOperations.FileProcessor;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.InvocationTargetException;

public class Driver{
    public static void main(String[] args){
        FileProcessor proc = new FileProcessor("input.txt","output.txt");
        long startTime = System.currentTimeMillis();
        int iterations = 1;
        for(int i=0; i<iterations; i++){
            PopulateObjects pop = new PopulateObjects(proc);
            pop.deserObjects();
            try{
                proc.writeToFile(pop.toString());
            }catch(IOException ioe){
                ioe.getMessage();
            }
        } 
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        long avgTime = totalTime/iterations;
        try{
            proc.writeToFile("Total time: "+totalTime/1000.000+" seconds");
        }catch(IOException ioe){
            ioe.getMessage();
        }
    }
}
