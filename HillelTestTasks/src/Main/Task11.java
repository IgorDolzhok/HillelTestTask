package Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task11 {
    private int id;
    private String name;

    public Task11(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof Task11)){
            return false;
        }
        if(this.id == ((Task11) obj).getId()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Task11{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    private static boolean listContains(List<Task11> list, Task11 task){
        for(Task11 t: list){
            if(t.equals(task)){
                return true;
            }
        }
        return false;
    }

    protected static List<Task11> getListOfEntities(){
        TestTask testTask = new TestTask();
        List<Task11> entities = new ArrayList<>();
        for(int x=0; x<10; x++){
            entities.add(new Task11(testTask.getRandomInt(1, 10), "Name"));
        }
        return entities;
    }



    protected static List<Task11> deleteDuplicates(List<Task11> tasks){
        List<Task11> result = new ArrayList<>();
        Iterator iterator = tasks.iterator();
            while (iterator.hasNext()) {
                Task11 task = (Task11) iterator.next();
                if(!listContains(result, task)){
                    result.add(task);
                }

            }

        return result;
    }

    public static void main(String[] args) {
        List<Task11> tasks = getListOfEntities();
        for(Task11 t: tasks){
            System.out.println("Id = "+t.getId()+" , name= "+t.getName());
        }
        tasks = deleteDuplicates(tasks);
        System.out.println("After sorting");
        for(Task11 t: tasks){
            System.out.println("Id = "+t.getId()+" , name= "+t.getName());
        }

    }


}
