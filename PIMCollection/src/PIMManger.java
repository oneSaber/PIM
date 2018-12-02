import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class PIMManger {
    private static PIMCollection collection;


    private void CommandNote(){
        System.out.println("---Enter a command (suported commands are List Create Save Load Quit)--");
    }

    static public PIMManger CreatePIMManger(){
        collection = PIMCollection.CreateCollection();
        return new PIMManger();
    }

    // COMMANDS LIST
    private void ListItems(Scanner scanner){
        System.out.println("List all or a type ?(All, todo,note,contact" +
                ",appointment and date");
        String Listtype = scanner.nextLine();
        switch (Listtype){
            case "All":collection.ListAll();break;
            case "todo":collection.ListItems(collection.getTodos());break;
            case "note":collection.ListItems(collection.getNotes());break;
            case "contact":collection.ListItems(collection.getContact());break;
            case "apponintment":collection.ListItems(collection.getAppointments());break;
            case "date":{
                System.out.println("input the date you want ,like dd/MM/yyyy");
                String dateString = scanner.nextLine();
                collection.ListItems(
                        collection.getItemsForDate(
                        (new PIMDate(dateString).GetTheDate())
                ));
            };break;
            default:System.out.println("Error Input!");break;
        }
    }

    public void Mananger() throws Exception{
        String Command = " ";
        while(!Command.equals("Quit")){
            CommandNote();
            Scanner scanner = new Scanner(System.in);
            Command = scanner.nextLine();
            switch (Command){
                case "List": ListItems(scanner);break;
                case "Create": Create();break;
                case "Save": Save();break;
                case "Load": Load();break;
                case "Quit": break;
                default:
                    System.out.println("Error input");
            }
        }
    }

    private void Create() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an item type ( todo, note, contact or appointment )");
        String Command = scanner.nextLine();
        switch (Command){
            case "todo":CreateTodo();break;
            case "note":CreateNote();break;
            case "appointment": CreateAppointment();break;
            case "contact": CreateContact();break;
            default:
                System.out.println("Error Input!");
        }
    }

    private void Save(){
        System.out.println("Items have been saved");
    }

    private void Load(){
        System.out.println("Items have been loaded!");
    }

    // COMMANDS Create and Type is todo
    private void CreateTodo() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date for todo item:");
        // 解析时间
        String todoTime = scanner.nextLine();
        System.out.println("Enter Todo Text:");
        String todoText = scanner.nextLine();

        System.out.println("Enter Todo Priority:");
        String todoPriority = scanner.nextLine();

        PIMTodo todo = new PIMTodo(todoPriority,todoTime,todoText);
        collection.add(todo);
    }

    // COMMANDS Create and Type is NOTE
    private void CreateNote(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Note Text:");
        String NoteText = scanner.nextLine();
        System.out.println("Enter Note Priority:");
        String Priority = scanner.nextLine();

        PIMNote note = new PIMNote(Priority,NoteText);
        collection.add(note);
    }

    // COMMANDS Create and Type is Appointment
    private void CreateAppointment() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the date of appointment:");
        String Date = scanner.nextLine();
        System.out.println("Enter the appointment description:");
        String Desc = scanner.nextLine();
        System.out.println("Enter the priority:");
        String Priority = scanner.nextLine();

        PIMAppointment appointment = new PIMAppointment(Priority,Date,Desc);
        collection.add(appointment);
    }

    // COMMANDS Create and Type is Contact
    private void CreateContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name:");
        String FirstName = scanner.nextLine();
        System.out.println("Enter last name:");
        String LastNmae = scanner.nextLine();
        System.out.println("Enter the Contact priority:");
        String Priority = scanner.nextLine();
        System.out.println("Enter the email address:");
        String EmailAddress = scanner.nextLine();
        PIMContact contact = new PIMContact(Priority,FirstName,LastNmae,EmailAddress);
        collection.add(contact);
    }
}
