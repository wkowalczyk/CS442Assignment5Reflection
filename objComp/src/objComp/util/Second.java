package objComp.util;

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
    
    @Override public boolean equals(Object obj){
        if(!(obj instanceof Second)){
            return false;
        }else if((((Second)obj).getDoubleValue() == DoubleValue) && (((Second)obj).getIntValue() == IntValue)){
            return true;
        }else{
            return false;
        }
    }
}
