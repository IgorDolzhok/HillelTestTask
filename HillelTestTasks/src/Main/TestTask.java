package Main;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class TestTask {
    public static void main(String[] args) throws IOException {
        TestTask testTask = new TestTask();
        System.out.println("Here is result of task 1:");
        testTask.task1();
        System.out.println("\nHere is result of task 2:");
        int [] arrayFromTask2 = arrayFromTask2 =testTask.task2(0, 10, 10);
        System.out.print("Values from array: ");
        for(int i: arrayFromTask2){
            System.out.print(i+ " ");
        }
        System.out.println("\nAverage value of array from task2 = "+
                testTask.getAvgFromIntArray(arrayFromTask2));
        System.out.println("Here is result of task 3:");
        testTask.task3(15);
        testTask.task3(13);
        System.out.println("Here is result of task 4:");
        for(char c: testTask.task4("abc")){
            System.out.print(c+" ");
        }
        System.out.println("\nHere is result of task 5:");
        System.out.println( testTask.task5());
        System.out.println("Here is result of task 6:");
        testTask.task6(4,5);

        System.out.println("Here is result of task 7:");
        Task7.analyzeFile("/home/ktech/IdeaProjects/HillelTestTasks/src/Resources/TestFile");

        System.out.println("Here is result of task 9:");
        System.out.println(Task9.getDate("22/01/2020 14:15"));
        System.out.println(Task9.getDate("22.01.2019 19:15:00"));
        System.out.println("Task 10: look at protected methods in this class");
        System.out.println("Here is result of task 11:");
        List<Task11> withDuplicates = Task11.getListOfEntities();
        System.out.println("List with duplicates:");
        for(Task11 t11: withDuplicates){
            System.out.println(t11.toString());
        }
        List<Task11> noDuplicates = Task11.deleteDuplicates(withDuplicates);
        System.out.println("List without duplicates:");
        for(Task11 t11: noDuplicates){
            System.out.println(t11.toString());
        }



    }

    public void task1(){
        for(int x=1; x<101; x++){
            if(x%3==0){
                if(x%5!=0) {
                    System.out.print("World ");
                }else{
                    System.out.print("HelloWorld ");
                }
            }else if(x%5==0){
                System.out.print("Hello ");
            }else {
                System.out.print(x+" ");
            }
        }
    }

    public int[] task2(int min, int max, int arrayLength){
       int[] array = new int[arrayLength];
        for(int x = 0; x<arrayLength; x++){
            array[x] = getRandomInt(min, max);
        }

       return array;
    }

    public boolean task3(int x){
        for(int y = 2; y<x; y++){
            if(x%y==0){
                System.out.println(x+" is not simple number");
                return false;
            }
        }
        System.out.println(x+ " is simple number");
        return true;
    }

    public char[] task4(String s){
        char [] array1 = s.toCharArray();
        Arrays.sort(array1);
        char [] array2 = new char[s.length()];
        boolean [] mark = new boolean[s.length()];
        Arrays.fill(mark, false);
        getCharCombinations(array1, array2, mark, 0, s.length());
        return array2;
    }

    public String task5(){
        StringBuilder str = new StringBuilder();

        for(int x=1; x<31; x++){
            String a = "("+x+")";
            str.append(a);
        }
        return str.toString();
    }

    public void task6(int height, int width){
        int [][] array = new int[height][width];
        for(int x=0; x<array.length;x++){
            for(int y=0; y<array[x].length; y++){
                array[x][y] = getRandomInt(0, 100);
            }
        }
        int length = array.length* array[0].length;
        int [] arrayLine = new int[length];
        int index = 0;
        for(int y=0; y<array.length; y++){
            for(int z = 0; z<array[y].length; z++){
                arrayLine[index+z] = array[y][z];
            }
            index+= array[y].length;
        }
        Arrays.sort(arrayLine);
        index=0;
        for(int x=0; x<array.length; x++){
            for(int y=0; y<array[x].length; y++){
                array[x][y] = arrayLine[index+y];
            }
            index+=array[x].length;
        }
        for(int x=0; x<array.length;x++){
            for(int y=0; y<array[x].length; y++){
                System.out.print(array[x][y]+" ");
            }
            System.out.println();
        }

    }

    protected void getCharCombinations(char[] array1, char [] array2, boolean [] mark,
                                       int length, int x){
        if(length == x){
            System.out.println(array2);
            return;
        }
        for(int y=0; y<x; y++){
            if(mark[y]==true){
                continue;
            }
            if(y>0 && array1[y]==array1[y-1] && mark[y-1]==false){
                continue;
            }
            mark[y]=true;
            array2[length] = array1[y];
            getCharCombinations(array1, array2, mark, length+1, x);
            mark[y]=false;
        }
    }
    protected int getRandomInt(int min, int max){
        max-=min;
        return (int) (Math.random()* ++max)+min;
    }

    protected float getAvgFromIntArray(int [] array){
        float sum = 0;
        float length = array.length;
        for(int x = 0; x<length; x++){
            sum+=array[x];
        }

        return sum/length;
    }




}
