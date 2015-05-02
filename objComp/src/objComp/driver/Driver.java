package objComp.driver;

import objComp.util.Logger;
import objComp.fileOperations.FileProcessor;
import objComp.util.PopulateObjects;
import objComp.util.First;
import objComp.util.Second;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.InvocationTargetException;

public class Driver{
    public static void main(String[] args){
		Logger log = Logger.getInstance();
		int LOGGER_VALUE = Integer.parseInt(args[3]);
		log.setDebugValue(LOGGER_VALUE);
		String inFile = args[0];
		String outFile = args[1];
        FileProcessor proc = new FileProcessor(inFile, outFile);
        long startTime = System.currentTimeMillis();
        int iterations = Integer.parseInt(args[2]);
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
