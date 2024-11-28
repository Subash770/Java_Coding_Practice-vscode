package programs;

import java.util.ArrayList;
import java.util.Collections;

public class ArraylistReverse{
    public ArrayList<Integer> reverse(ArrayList<Integer> list){
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args){

       ArrayList<Integer> l=new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        ArraylistReverse ar=new ArraylistReverse();
        ArrayList<Integer> reversedList=ar.reverse(l);
        System.out.println("The reveresed array list : "+reversedList);

    }
}