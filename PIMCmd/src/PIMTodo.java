import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PIMTodo extends  PIMEntity {
    private Calendar Date;
    private String TodoText;
    PIMTodo(String priorty, Calendar date,String todoText){
        Priority = priorty;
        Date = date;
        TodoText = todoText;
    }
    PIMTodo(){
        Priority = "normal";
    }

    public void FromString(String arg){}
    public String ToString(){
        return String.format("TODO: %s %d/%d/%d %s",getPriority(),Date.getTime().getDate(),
                Date.getTime().getMonth(),
                Date.getTime().getYear(),
                TodoText);
    }
}
