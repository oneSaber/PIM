import java.util.Calendar;

public class PIMNote extends PIMEntity {

    private String NoteText;
    PIMNote(String priority, String noteText){
        Type = "note";
        Priority = priority;
        NoteText = noteText;
    }

    public void FromString(String arg){}
    public String ToString(){
        return String.format("%s %s",Priority,NoteText);
    }
}
