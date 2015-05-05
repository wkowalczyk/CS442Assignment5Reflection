package objComp.util;

import objComp.util.Logger;

public class Second{
    private double DoubleValue;
    private int IntValue;
    
    public Second(){
    }
    
    public void setIntValue(int iIn){
        IntValue = iIn;
    }
    
    public void setDoubleValue(double dIn){
        DoubleValue = dIn;
    }
    
    public double getDoubleValue(){
        return DoubleValue;
    }
    
    public int getIntValue(){
        return IntValue;
    }
    
    @Override 
    public boolean equals(Object obj){
		Logger.printToStdout(2, "Equals is being overriden in Second.");
        if(!(obj instanceof Second)){
            return false;
        }else if((((Second)obj).getDoubleValue() == DoubleValue) && (((Second)obj).getIntValue() == IntValue)){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public int hashCode(){
		Logger.printToStdout(2, "hashCode is being overriden in Second.");
        int hash = 1;
        hash = hash * 47;
        hash = hash * IntValue;
        hash = hash * (int)DoubleValue;
        return hash;
    }
}
