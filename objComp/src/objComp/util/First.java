package objComp.util;

public class First{
    private int IntValue;
    private String StringValue;
    
    public First(){
    }
    
    public void setIntValue(int iIn){
        IntValue = iIn;
    }
    
    public void setStringValue(String sIn){
        StringValue = sIn;
    }
    
    public int getIntValue(){
        return IntValue;
    }
    
    public String getStringValue(){
        return StringValue;
    }
    
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof First)){
            return false;
        }else if((((First)obj).getIntValue() == IntValue) && (((First)obj).getStringValue().equals(StringValue))){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public int hashCode(){
        int hash = 1;
        hash = hash*47;
        hash = hash*StringValue.hashCode();
        hash = hash*IntValue;
        return hash;
    }
}
