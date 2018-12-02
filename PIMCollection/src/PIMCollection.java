import java.util.Collection;
import java.util.*;

public class PIMCollection implements Collection{
    // 使用hashmapkey的取值范围为todo,note,appointment和contact
    private static HashMap<String, LinkedList<PIMEntity>> pimcollection;


    // 实现collation接口的一些方法
    public int size(){
        return pimcollection.get("todo").size()+
                pimcollection.get("note").size()+
                pimcollection.get("appointment").size()+
                pimcollection.get("contact").size();
    }
    public void clear() {}

    public boolean isEmpty(){
        if(size() == 0)
            return true;
        else return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    public Iterator iterator(){
        return null;
    }
    Boolean remove(PIMEntity e){return false;}
    public PIMEntity[] toArray(){return null;}

    @Override
    public boolean add(Object o) {
        return false;
    }
    @Override
    public boolean remove(Object o) {
        return false;
    }
    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }


    // 创建一个collection
    static public  PIMCollection CreateCollection(){
        pimcollection = new HashMap<String,LinkedList<PIMEntity>>();
        // 初始化表
        pimcollection.put("todo",new LinkedList<PIMEntity>());
        pimcollection.put("note",new LinkedList<PIMEntity>());
        pimcollection.put("appointment",new LinkedList<PIMEntity>());
        pimcollection.put("contact", new LinkedList<PIMEntity>());
        return new PIMCollection();
    }

    // List -a
    public void ListAll(){
        if(isEmpty()){
            System.out.println("there is no item!");
        }
        int count = 0;
        for(Map.Entry<String, LinkedList<PIMEntity>> entry:pimcollection.entrySet()){
            if(entry.getValue().size()==0)
                continue;
            for(PIMEntity item: entry.getValue()) {

                System.out.printf("Item %d: %s\n", ++count, item.ToString());
            }
        }
    }

    public void ListItems(LinkedList<PIMEntity> Items){
        if(Items.size() == 0)
        {
            System.out.println("There is no items!");
            return;
        }
        int count = 1;
        for(PIMEntity item: Items){
            System.out.printf("item %d: %s\n",count,item.ToString());
            count++;
        }
    }

    // LIST -t [type]
    public LinkedList<PIMEntity> getNotes(){
        return pimcollection.get("note");
    }

    public LinkedList<PIMEntity> getTodos(){
        return pimcollection.get("todo");
    }

    public LinkedList<PIMEntity> getAppointments(){
        return pimcollection.get("appointment");
    }

    public LinkedList<PIMEntity> getContact(){
        return pimcollection.get("contact");
    }

    public LinkedList<PIMEntity> getItemsForDate(Date d){
        LinkedList<PIMEntity> result = new LinkedList<PIMEntity>();

        // 拥有date属性的只有todo和appointment,只需要遍历这两个就可以了
        LinkedList<PIMEntity> todoList = pimcollection.get("todo");
        LinkedList<PIMEntity> appointmentList = pimcollection.get("appointment");

        // 遍历todolist 和appointmentlist 寻找日期相同的项
        for(PIMEntity item : todoList){
            if(d.equals(((PIMTodo)item).GetDate())){
                result.add(item);
            }
        }
        for(PIMEntity item : appointmentList){
            if(d.equals(((PIMAppointment)item).GetDate())){
                result.add(item);
            }
        }
        return result;
    }

    // 向PIMcollection中添加内容，通过type来分类加入不同的列表中
    public boolean add(PIMEntity item){
        switch (item.getType()){
            case "todo":pimcollection.get("todo").add(item);break;
            case "note":pimcollection.get("note").add(item);break;
            case "appointment":pimcollection.get("appointment").add(item);break;
            case "contact": pimcollection.get("contact").add(item);break;
            default:System.out.println("Error type!");
        }
        return true;
    }
}
