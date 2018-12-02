import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class PIMDate {
    private Calendar cla;
    PIMDate()
    {
        cla = Calendar.getInstance();
    }
    PIMDate(String dateString){
        cla = GetCalendate(dateString);
        if(cla == null)
            cla = Calendar.getInstance();
    }
    Calendar GetCalendate(String DateString) {
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date  = simpleDateFormat.parse(DateString);
            Calendar cla = Calendar.getInstance();
            cla.setTime(date);
            return cla;
        }catch (Exception e){
            System.out.println("日期格式错误，正确格式为: dd/MM/yyyy");
            return null;
        }
    }
    public Date GetTheDate(){
        return cla.getTime();
    }
    public String toString()
    {
        return String.format("%d年 %d月 %d日",cla.getTime().getYear()+1900,cla.getTime().getMonth()+1,cla.getTime().getDate());
    }
}
