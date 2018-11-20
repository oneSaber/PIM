public class PIMContact extends PIMEntity {
    private String FirstName;
    private String LastName;
    private String EmailAddress;
    PIMContact(String priority,String firstname,String lastname,String emailaddress){
        Priority = priority;
        FirstName = firstname;
        LastName = lastname;
        EmailAddress = emailaddress;
    }
    public void FromString(String arg){}
    public String ToString(){
        return String.format("Contact: priority: %s firstname: %s lastname: %s eamiladdress: %s",
                Priority,FirstName,LastName,EmailAddress);
    }
}
