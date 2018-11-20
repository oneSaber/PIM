import java.util.Calendar;

// PIM 的启动器
public class PIMStart {
    public static void main(String[] args) throws Exception{
        PIMManger manger = PIMManger.CreatePIMManger();
        manger.Mananger();
    }
}
