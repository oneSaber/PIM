// author 赵善吉 16130120129 13578600844@qq.com

public abstract class PIMEntity {
    String Priority;  // 优先级

    PIMEntity(){
        Priority = "Normal";
    }
    PIMEntity(String priority){
        Priority = priority;
    }
    public String getPriority(){
        return  Priority;
    }
    public void setPriority(String priority){
        Priority = priority;
    }
    abstract public void FromString(String arg);
    abstract public String ToString();
}
