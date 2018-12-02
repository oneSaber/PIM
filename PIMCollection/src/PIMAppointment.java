import java.util.Date;

public class PIMAppointment extends PIMEntity {
    private PIMDate Date;
    private String Description;

    PIMAppointment(String prioroty, String date,String desc){
        Type = "appointment";
        Priority = prioroty;
        Date = new PIMDate(date);
        Description = desc;
    }
    public Date GetDate(){
        return Date.GetTheDate();
    }
    public void FromString(String arg){}
    public String ToString(){
        return String.format("Appointment: %S %s %s",getPriority(),
                Date.toString(),Description);
    }
}
