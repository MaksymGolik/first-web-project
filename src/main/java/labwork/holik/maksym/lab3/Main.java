package labwork.holik.maksym.lab3;
import labwork.holik.maksym.lab2.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyListImpl list = new MyListImpl();
        System.out.println(list);
        list.add(new Arena("ARENA1","Shevchenkovskiy",7800,new int[]{9,1,2018},31200,10,true,10,4,6,true));
        list.add(new Detached_House("HOUSE1","Industrialniy",150.5,new int[]{20,3,2008},1300200,80000,8,303,1,true));
        list.add(new Office("OFFICE","Osnovyanskiy",150,new int[]{9,1,2018},160,6,true,"AvePlaza",2,4,false));
        list.add(new Office("OFFICE","Kholodno-Gorskiy",150,new int[]{9,1,2018},160,6,true,"DiamondCity",2,4,false));
        System.out.println(list);
        MyListImpl offices = new MyListImpl();
        for(Object estate: list){
            if(estate.getClass().equals(Office.class)) offices.add((Estate) estate);;
        }
        System.out.println(offices);
//        if(list.remove(new Detached_House("HOUSE1",150.5,new int[]{20,3,2008},1300200,80000,8,303,1,true)))System.out.println("Successfully deleted");
//        System.out.println(list);
//        System.out.println(list.size());
//        list.add(new Apartment("APARTMENT", 40, new int[]{9,1,2018}, 860000, 43000, 4, "ODESSAKING", 14, true, 5.3));
//        Estate []array = (Estate[])list.toArray();
//        System.out.println(array[0]);
//        System.out.println(array[1]);
//
//        System.out.println(list.contains(new Office("OFFICE",150,new int[]{9,1,2018},160,6,true,2,4,false)));
//
//        Iterator<Estate>it = list.iterator();
//        while(it.hasNext())System.out.println(it.next());
//        it.remove();
//        for(Object estate: list)System.out.println(estate);
//
//        list.clear();
//        System.out.println(list);
//        list.add(new Detached_House("HOUSE1","Industrialniy",150.5,new int[]{20,3,2008},1300200,80000,8,303,1,true),new Office("OFFICE4","Industrialniy",899,new int[]{9,1,2018},160,6,true,"AvePlaza",2,4,false));
//        System.out.println(list);
    }
}