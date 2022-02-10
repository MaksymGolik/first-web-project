package labwork.holik.maksym.lab2;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
//        Comparator<Estate> estateComparatorArea = new Comparator<Estate>() {
//            @Override
//            public int compare(Estate o1, Estate o2) {
//                if(o1.area==o2.area)return 0;
//                return o1.area<o2.area? -1:1;
//            }
//        };
//    Estate []estates=new Estate[]{
//            new Detached_House("HOUSE", 180, new int[]{9,1,2015}, 1500600, 85000, 4, 145, 2, true),
//            new Apartment("APARTMENT", 40, new int[]{9,1,2018}, 860000, 43000, 4, "ODESSAKING", 14, true, 5.3),
//            new Office("OFFICE",150,new int[]{9,1,2018},160,6,true,2,4,false),
//            new Arena("ARENA",7800,new int[]{9,1,2018},31200,12,true,12,4,4,true),
//            new Apartment("APARTMENT2", 40, new int[]{9,1,2015}, 860000, 41000, 4, "SkyHome", 18, true, 5.3)
//    };
//    for(Estate i:estates){
//        System.out.println(i.toString());
//    }
//    System.out.println("-------------------------");
//    Arrays.sort(estates,estateComparatorArea);
//        for(Estate i:estates){
//            System.out.println(i.toString());
//        }
//        System.out.println("-------------------------");
//        Arrays.sort(estates);
//        for(Estate i:estates){
//            System.out.println(i.toString());
//        }
//        System.out.println("-------------------------");
//        Detached_House d_h[] = new Detached_House[]{
//                new Detached_House("HOUSE1",150.5,new int[]{20,3,2008},1300200,80000,8,303,1,true),
//                new Detached_House("HOUSE2",130,new int[]{16,9,2009},1100999,75000,6,350,1,false),
//                new Detached_House("HOUSE3",260,new int[]{2,2,2020},2500000,150999,16,400.2,2,true)
//        };
//        Comparator<Detached_House>DHComLandArea=new Comparator<Detached_House>() {
//            @Override
//            public int compare(Detached_House o1, Detached_House o2) {
//                if(o1.land_area==o2.land_area)return 0;
//                return o1.land_area<o2.land_area?-1:1;
//            }
//        };
//        System.out.println("-------------------------");
//        for(Detached_House i:d_h){
//            System.out.println(i.toString());
//        }
//        System.out.println("-------------------------");
//        Arrays.sort(d_h,DHComLandArea);
//        for(Detached_House i:d_h){
//            System.out.println(i.toString());
//        }
//        System.out.println("-------------------------");
//        Arrays.sort(d_h,estateComparatorArea);
//        for(Detached_House i:d_h){
//            System.out.println(i.toString());
//        }
//        Arena arena[] = new Arena[]{
//                new Arena("ARENA1",7800,new int[]{9,1,2018},31200,10,true,10,4,6,true),
//                new Arena("ARENA2",6900,new int[]{1,1,1999},25000,12,true,12,2,4,false),
//                new Arena("ARENA3",11200,new int[]{4,11,2015},47000,16,true,20,8,8,true)
//        };
//        Comparator<Arena> arenaComparatorDressingR = new Comparator<Arena>() {
//            @Override
//            public int compare(Arena o1, Arena o2) {
//                if(o1.dressing_rooms==o2.dressing_rooms)return 0;
//                return o1.dressing_rooms<o2.dressing_rooms?-1:1;
//            }
//        };
//        Comparator<Arena> arenaComparatorSectors = new Comparator<Arena>() {
//            @Override
//            public int compare(Arena o1, Arena o2) {
//                if(o1.sectors==o2.sectors)return 0;
//                return o1.sectors<o2.sectors?-1:1;
//            }
//        };
//        System.out.println("-------------------------");
//        for(Arena i:arena){
//            System.out.println(i.toString());
//        }
//        System.out.println("-------------------------");
//        Arrays.sort(arena,arenaComparatorDressingR);
//        for(Arena i:arena){
//            System.out.println(i.toString());
//        }
//        System.out.println("-------------------------");
//        Arrays.sort(arena,arenaComparatorSectors);
//        for(Arena i:arena){
//            System.out.println(i.toString());
//        }
        Detached_House dh1 = new Detached_House("HOUSE1","Шевченковский",150.5,new int[]{20,3,2008},1300200,80000,8,303,1,true);
        Detached_House dh2 = new Detached_House("HOUSE1", "Индустриальный",150.5,new int[]{20,3,2008},1300200,80000,8,303,1,true);
        System.out.println(dh2.equals(dh1));
    }
}
