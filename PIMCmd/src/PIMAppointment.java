public class PIMAppointment extends PIMEntity {
    private PIMDate Date;
    private String Description;

    PIMAppointment(String prioroty, String date,String desc){
        Priority = prioroty;
        Date = new PIMDate(date);
        Description = desc;
    }
    public void FromString(String arg){}
    public String ToString(){
        return String.format("Appointment: %S %s %s",getPriority(),
                Date.toString(),Description);
    }
}
