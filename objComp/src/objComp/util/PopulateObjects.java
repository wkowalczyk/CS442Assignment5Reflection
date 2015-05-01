package objComp.util;

import objComp.fileOperations.FileProcessor;
import java.util.HashMap;
import java.util.ArrayList;

public class PopulateObjects{
    private HashMap<First,Integer> first = new HashMap<First, Integer>();
    private HashMap<Second,Integer> second = new HashMap<Second, Integer>();
    
    public void deserObjects(){
        FileProcessor proc = new FileProcessor("input.txt","output.txt");
        String line = proc.readLine();
        while(line != null){
            String fqn = line.split(":")[1].trim();
            String clsName = fqn;      // generalize
            Class cls = Class.forName(clsName);
            Object obj = cls.newInstance();  
            if(fqn.endsWith("First")){
                for(int i=0; i<2; i++){
                    line = proc.readLine();
                    String[] parts = line.split(", ");
                    String typeString = parts[0].split("=")[1].trim();
                    String nameString = parts[1].split("=")[1].trim();
                    String valString = parts[2].split("=")[1].trim();
                    Class sigClass = Class.forName(typeString);
                    
                    Class[] signature = new Class[1];
                    //signature[0] = Integer.TYPE;            // generalize
                    signature[0] = sigClass.TYPE;            // generalize
                    String methdName = "set" + nameString;          // generalize
                    Method meth = cls.getMethod(methodName, signature); 
                     
                    Object[] params = new Object[1]; 
                    params[0] = new Integer(17);            // generalize
                    Object result = meth.invoke(obj, params);
                }
            }else if(fqn.endsWith("Second")){
                for(int i=0; i<2; i++){
                    line = proc.readLine();
                    String[] parts = line.split(", ");
                    String typeString = parts[0].split("=")[1].trim();
                    String nameString = parts[1].split("=")[1].trim();
                    String valString = parts[2].split("=")[1].trim();
                    Class[] signature = new Class[1];
                    signature[0] = Integer.TYPE;            // generalize
                    String methdName = "set" + "IntValue";          // generalize
                    Method meth = cls.getMethod(methodName, signature);  
                    Object[] params = new Object[1]; 
                    params[0] = new Integer(17);            // generalize
                    Object result = meth.invoke(obj, params);
                }
            }else{
                //error
            }
        }
    }
}
