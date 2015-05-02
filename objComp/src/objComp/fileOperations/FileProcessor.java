package objComp.fileOperations;

import objComp.util.Logger;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;

public class FileProcessor{
    private BufferedReader buffReader = null;
    private String nextWord;
    private BufferedWriter buffWriter = null;

    public FileProcessor(String inFileName, String outFileName){
        try{
            FileReader inFile = new FileReader(inFileName);
            buffReader = new BufferedReader(inFile);
            buffWriter = new BufferedWriter(new FileWriter(outFileName, true));
        }catch(FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
        }catch(IOException ioe){
            System.out.println("I/O Exception");
        }
    }

    public String readLine(){
        Logger.printToStdout(1, "The file is being read from."); 
        String nextLine = null;
        try{
            nextLine = buffReader.readLine();
        }catch(IOException ioe){
            System.out.println("An IO Exception has occurred.");
        }
        if(nextLine!=null){
            return nextLine.trim();
        }else{
            return null;
        }
    }
    
    public void writeToFile(String message) throws IOException{
        Logger.printToStdout(2, "The file is being written to.");
        buffWriter.write(message);
        buffWriter.newLine();
        buffWriter.flush();
    }
}
