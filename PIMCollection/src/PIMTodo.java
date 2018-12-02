import java.util.Date;

public class PIMTodo extends  PIMEntity {
    private PIMDate Date;
    private String TodoText;
    PIMTodo(String priorty, String date,String todoText){
        Type = "todo";
        Priority = priorty;
        Date = new PIMDate(date);
        TodoText = todoText;
    }
    PIMTodo(){
        Priority = "normal";
    }

    public Date GetDate(){
        return Date.GetTheDate();
    }
    public void FromString(String arg){}
    public String ToString(){
        return String.format("TODO: %s %s %s",getPriority(),
                Date.toString(), TodoText);
    }
}
