package objComp.util;

import objComp.fileOperations.FileProcessor;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.InvocationTargetException;

public class PopulateObjects{
    private HashMap<First,Integer> first = new HashMap<First, Integer>();
    private HashMap<Second,Integer> second = new HashMap<Second, Integer>();
    private HashMap<String,Class> types = new HashMap<String,Class>();
    private FileProcessor proc;
    
    public PopulateObjects(FileProcessor fpIn){
        proc = fpIn;
        types.put("Integer", Integer.TYPE);
        types.put("String", String.class);
        types.put("Double", Double.TYPE);
    }
    public void deserObjects(){
        String line = proc.readLine();
        while(line != null){
            String fqn = line.split(":")[1].trim();
            String clsName = fqn;
            try{
                Class cls = Class.forName(clsName);
                Object obj = cls.newInstance();  
                for(int i=0; i<2; i++){
                    line = proc.readLine();
                    String[] parts = line.split(", ");
                    String typeString = parts[0].split("=")[1].trim();
                    String nameString = parts[1].split("=")[1].trim();
                    String valString = parts[2].split("=")[1].trim();
                    Class sigClass = Class.forName(typeString);
                    
                    Class[] signature = new Class[1];
                    signature[0] = types.get(sigClass);
                    String methdName = "set" + nameString;
                    Method meth = cls.getMethod(methdName, signature); 
                     
                    Object[] params = new Object[1]; 
                    params[0] = createParam(typeString, nameString);
                    Object result = meth.invoke(obj, params);
                }
            }catch(ClassNotFoundException cnfe){
                cnfe.getMessage();
            }catch(InstantiationException ie){
                ie.getMessage();
            }catch(NoSuchMethodException nsme){
                nsme.getMessage();
            }catch(IllegalAccessException iae){
                iae.getMessage();
            }catch(InvocationTargetException ite){
                ite.getMessage();
            }
        }
    }

    public Object createParam(String type, String value){
        if(type.equals("int")){
            return new Integer(value);
        }else if(type.equals("double")){
            return new Double(value);
        }else if(type.equals("String")){
            return value;
        }else{
            return null;
        }
    }

    public void addValue(Object newObj){
        if(newObj instanceof First){
            if(first.containsKey((First)newObj)){
                int temp = first.get((First)newObj);
                first.put((First)newObj, temp+1);
            }else{
                first.put((First)newObj, 1);
            }
        }else if(newObj instanceof Second){
            if(second.containsKey((Second)newObj)){
                int temp = second.get((First)newObj);
                second.put((Second)newObj, temp+1);
            }else{
                second.put((Second)newObj, 1);
            }
        }
    }
    
    public int countUniqueFirst(){
        return first.size();
    }

    public int countAllFirst(){
        ArrayList<Integer> firstCounts = new ArrayList<Integer>(first.values());
        int numClasses = 0;
        for(int i =0; i<firstCounts.size(); i++){
            numClasses+=firstCounts.get(i);
        }
        return numClasses;
    }
    
    public int countUniqueSecond(){
        return second.size();
    }

    public int countAllSecond(){
        ArrayList<Integer> secondCounts = new ArrayList<Integer>(second.values());
        int numClasses = 0;
        for(int i =0; i<secondCounts.size(); i++){
            numClasses+=secondCounts.get(i);
        }
        return numClasses;
    }
    public String toString(){
        String output;
        output = "Number of non-duplidate First objects: "+ countUniqueFirst();
        output += "\nTotal Number of First objects: " + countAllFirst();
        output += "\nNumber of non-duplidate Second objects: " + countUniqueSecond();
        output += "\nTotal Number of Second objects: " + countAllSecond();
        output += "\n";
        return output;
    }
}
