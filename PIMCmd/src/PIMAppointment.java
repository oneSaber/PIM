import java.util.Calendar;

public class PIMAppointment extends PIMEntity {
    private Calendar Date;
    private String Description;

    PIMAppointment(String prioroty, Calendar date,String desc){
        Priority = prioroty;
        Date = date;
        Description = desc;
    }
    public void FromString(String arg){}
    public String ToString(){
        return "hello world";
    }
}
