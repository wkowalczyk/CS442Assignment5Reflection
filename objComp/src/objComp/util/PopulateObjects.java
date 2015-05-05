package objComp.util;

import objComp.fileOperations.FileProcessor;
import objComp.util.Logger;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.InvocationTargetException;

public class PopulateObjects{
    private Map<First,Integer> first = new HashMap<First, Integer>();
    private Map<Second,Integer> second = new HashMap<Second, Integer>();
    private Map<String,Class> types = new HashMap<String,Class>();
    private FileProcessor proc;
    
    public PopulateObjects(FileProcessor fpIn){
        proc = fpIn;
        types.put("int", Integer.TYPE);
        types.put("String", String.class);
        types.put("double", Double.TYPE);
    }
    public void deserObjects(){
        String line = proc.readLine();
        //System.out.println(line);
        while(line != null){ 
            //System.out.println(line.split(":")[0]);
            String fqn = line.split(":")[1].trim();
            String clsName = fqn;
            try{
                Class cls = Class.forName(clsName);
                Object obj = cls.newInstance();  
                for(int i=0; i<2; i++){
                    line = proc.readLine();
                    //System.out.println(line);
                    String[] parts = line.split(", ");
                    String typeString = parts[0].split("=")[1].trim();
                    String nameString = parts[1].split("=")[1].trim();
                    String valString = parts[2].split("=")[1].trim();
                    
                    Class[] signature = new Class[1];
                    signature[0] = types.get(typeString);
                    //System.out.println("set" + nameString);
                    String methdName = "set" + nameString;
                    Method meth = cls.getMethod(methdName, signature); 
                     
                    Object[] params = new Object[1]; 
                    params[0] = createParam(typeString, valString);
                    Object result = meth.invoke(obj, params);
                }
                addToMap(obj);
                line = proc.readLine();
                //System.out.println(line);
            }catch(ClassNotFoundException cnfe){
                System.out.println("Class Not Found Exception");
                System.err.println(cnfe.getMessage());
            }catch(InstantiationException ie){
                System.out.println("Instantiation Exception");
                System.err.println(ie.getMessage());
            }catch(NoSuchMethodException nsme){
                System.out.println("No Such Method Exception");
                System.err.println(nsme.getMessage());
            }catch(IllegalAccessException iae){
                System.out.println("Illegal Access Exception");
                System.err.println(iae.getMessage());
            }catch(InvocationTargetException ite){
                System.out.println("Invocation Target Exception");
                System.err.println(ite.getMessage());
            }finally{
                while(line!=null && !line.startsWith("fqn")){
                    line = proc.readLine();
                }
            }
        }
    }

    public Object createParam(String type, String value){
		Logger.printToStdout(4, "Creating parameters.");
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

    public void addToMap(Object newObj){
		Logger.printToStdout(3, "Adding to map.");
        if(newObj instanceof First){
            if(first.containsKey((First)newObj)){
                int temp = first.get((First)newObj);
                first.put((First)newObj, temp+1);
            }else{
                first.put((First)newObj, 1);
            }
        }else if(newObj instanceof Second){
            if(second.containsKey((Second)newObj)){
                int temp = second.get((Second)newObj);
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
        List<Integer> firstCounts = new ArrayList<Integer>(first.values());
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
        List<Integer> secondCounts = new ArrayList<Integer>(second.values());
        int numClasses = 0;
        for(int i =0; i<secondCounts.size(); i++){
            numClasses+=secondCounts.get(i);
        }
        return numClasses;
    }
    public String toString(){
        String output;
        output = "Number of non-duplicate First objects: "+ countUniqueFirst();
        output += "\nTotal Number of First objects: " + countAllFirst();
        output += "\nNumber of non-duplicate Second objects: " + countUniqueSecond();
        output += "\nTotal Number of Second objects: " + countAllSecond();
        return output;
    }
}
