package labwork.holik.maksym.lab4.DAO;

import labwork.holik.maksym.lab2.Apartment;
import labwork.holik.maksym.lab2.Estate;
import labwork.holik.maksym.lab2.Office;
import labwork.holik.maksym.lab3.MyListImpl;

import java.util.HashMap;
import java.util.Map;

public class CollectionDAO implements IMyDAO {
    private static MyListImpl list = new MyListImpl();
    private static final String[] districts = new String[]{"Индустриальный","Московский","Основянский","Слободской","Холодногорский","Новобаварский","Немышлянский","Шевченковский","Киевский"};
    private static Map<String,int[]> apartmentcomplexes = new HashMap<>();
    private static Map<String,int[]> businesscenters = new HashMap<>();
    static {
        apartmentcomplexes.put("Алексеевские акварели",new int[]{1,7});
        apartmentcomplexes.put("Green Town",new int[]{2,1});
        apartmentcomplexes.put("Урбан Сити",new int[]{3,8});
        apartmentcomplexes.put("Urban One Sumskaya",new int[]{4,8});
        apartmentcomplexes.put("Воробьевы горы",new int[]{5,1});
        apartmentcomplexes.put("Журавлевский",new int[]{6,7});
        apartmentcomplexes.put("Инфинити",new int[]{7,4});
        apartmentcomplexes.put("Мир",new int[]{8,2});
        apartmentcomplexes.put("Московский",new int[]{9,1});
        apartmentcomplexes.put("Победы 85",new int[]{10,4});
        ////
        businesscenters.put("DiamondCity",new int[]{1,7});
        businesscenters.put("AvePlaza",new int[]{2,7});
        businesscenters.put("Капиталист",new int[]{3,7});
        businesscenters.put("Sun City Premium",new int[]{4,8});
        businesscenters.put("Центральный",new int[]{5,8});
        list.add(new Apartment("APARTMENT1","Шевченковский",80.6,new int[]{2015,9,13},1300500,9300,3,"Алексеевские акварели",13,true,6.3));
        list.add(new Apartment("APARTMENT2","Киевский",60.4,new int[]{2019,10,5},800000,7600,2,"Урбан Сити",18,false,4.4));
        list.add(new Apartment("APARTMENT3","Московский",56,new int[]{2017,12,12},890333,14000,3,"Московский",11,true,4.9));
        list.add(new Apartment("APARTMENT4","Холодногорский",99.9,new int[]{2021,6,4},2600333,25000,5,"Инфинити",9,true,9.9));
        list.add(new Apartment("APARTMENT5","Шевченковский",77.7,new int[]{2020,9,13},3600444,33444,4,"Журавлевский",15,false,10.9));
        list.add(new Apartment("APARTMENT6","Холодногорский",45.8,new int[]{2010,11,22},800776,8901,2,"Победы 85",11,true,3.6));
        list.add(new Apartment("APARTMENT7","Шевченковский",57.7,new int[]{2013,9,22},966335,9100,2,"Алексеевские акварели",7,false,4.5));
        list.add(new Office("OFFICE1","Шевченковский",250,new int[]{2016,7,13},400,3,true,"DiamondCity",1,4,false));
        list.add(new Office("OFFICE2","Шевченковский",255.7,new int []{2019,6,26},450,4,true,"AvePlaza",2,4,false));
        list.add(new Office("OFFICE3","Киевский",400,new int[]{2015,4,3},750,6,true,"Sun City Premium",3,6,true));
        list.add(new Office("OFFICE4","Шевченковский",200,new int[]{2018,11,14},300,2,true,"AvePlaza",1,5,false));
    }

    private int[] dateToArray(String date){
        String []strdate = date.split("-");
        int[] Date = new int[3];
        for(int i=0;i<3;i++){
            Date[i]=Integer.parseInt(strdate[i]);
        }
        return Date;
    }

    @Override
    public MyListImpl getALLapartments() {
        MyListImpl apartments = new MyListImpl();
        for(Object estate:list){
            if(estate.getClass().equals(Apartment.class))apartments.add((Estate)estate);
        }
        return apartments;
    }

    @Override
    public MyListImpl getALLoffices() {
        MyListImpl offices = new MyListImpl();
        for(Object estate:list){
            if(estate.getClass().equals(Office.class))offices.add((Estate)estate);
        }
        return offices;
    }

    @Override
    public void insertApartment(String name, double area, String d_of_b, int purchase, int rent, int rooms, int idCOMP, int floor, boolean sepWC, double balcony) {
        String district ="";
        String complex ="";
        for (Map.Entry<String,int[]> entry : apartmentcomplexes.entrySet())
        {
            int[]values = entry.getValue();
            if(values[0]==idCOMP){
                district = districts[values[1]];
                complex = entry.getKey();
            }
        }
        int[]Date = dateToArray(d_of_b);
        list.add(new Apartment(name,district,area,Date,purchase,rent,rooms,complex,floor,sepWC,balcony));
    }

    @Override
    public void insertOffice(String name, double area, String d_of_b, int cap, int em_ex, boolean park, int idCEN, int con_h, int neg_r, boolean b_sec) {
        String district ="";
        String center ="";
        for (Map.Entry<String,int[]> entry : businesscenters.entrySet())
        {
            int[]values = entry.getValue();
            if(values[0]==idCEN){
                district = districts[values[1]];
                center = entry.getKey();
            }
        }
        int[]Date = dateToArray(d_of_b);
        list.add(new Office(name,district,area,Date,cap,em_ex,park,center,con_h,neg_r,b_sec));
    }

    @Override
    public void removeApartment(String name) {
        int index=0;
        for(Estate estate:list){
            if(name.equals(estate.getName()))break;
            index++;
        }
        list.remove(index);
    }

    @Override
    public void removeOffice(String name) {
        int index=0;
        for(Estate estate:list){
            if(name.equals(estate.getName()))break;
            index++;
        }
        list.remove(index);
    }

    @Override
    public void updateApartment(String name, double area, int purchase, int rent, int rooms, boolean sepWC, double balcony) {
        for(Estate estate:list){
            if(name.equals(estate.getName())){
                estate.setArea(area);
                ((Apartment)estate).setPurchase_price(purchase);
                ((Apartment)estate).setRent_price(rent);
                ((Apartment)estate).setRooms(rooms);
                ((Apartment)estate).setSeparate_bathroom(sepWC);
                ((Apartment)estate).setBalcony_area(balcony);
                break;
            }
        }
    }

    @Override
    public void updateOffice(String name, double area, int cap, int em_ex, boolean park, int con_h, int neg_r, boolean b_sec) {
        for (Estate estate : list) {
            if (name.equals(estate.getName())) {
                estate.setArea(area);
                ((Office)estate).setCapacity(cap);
                ((Office)estate).setEmergency_exits(em_ex);
                ((Office)estate).setParking(park);
                ((Office)estate).setConference_halls(con_h);
                ((Office)estate).setNegotiation_rooms(neg_r);
                ((Office)estate).setBiometric_security(b_sec);
                break;
            }
        }
    }

    @Override
    public MyListImpl getOffices_samedistrict_theAps(String ApsName) {
        MyListImpl offices = new MyListImpl();
        String district="";
        for (Estate estate : list) {
            if (ApsName.equals(estate.getName())) {
                district=estate.getCity_district();
                break;
            }
        }
        for (Estate estate : list) {
            if (district.equals(estate.getCity_district())&&estate.getClass().equals(Office.class)) {
                offices.add(estate);
            }
        }
        return offices;
    }

    @Override
    public MyListImpl getAps_samedistrict_theOffice(String OfficeName) {
        MyListImpl apartments = new MyListImpl();
        String district="";
        for (Estate estate : list) {
            if (OfficeName.equals(estate.getName())) {
                district=estate.getCity_district();
                break;
            }
        }
        for (Estate estate : list) {
            if (district.equals(estate.getCity_district())&&estate.getClass().equals(Apartment.class)) {
                apartments.add(estate);
            }
        }
        return apartments;
    }

    @Override
    public MyListImpl getAps_by_purchase_range(int min, int max) {
        MyListImpl apartments = new MyListImpl();
        for (Estate estate : list) {
            if (estate.getClass().equals(Apartment.class)) {
                if(((Apartment) estate).getPurchase_price()<max&&((Apartment) estate).getPurchase_price()>min)apartments.add(estate);
            }
        }
        return apartments;
    }

    @Override
    public MyListImpl getOffices_where_capacity_greater_than_desc(int capacity) {
        MyListImpl offices = new MyListImpl();
        for (Estate estate : list) {
            if (estate.getClass().equals(Office.class)) {
                if(((Office) estate).getCapacity()>capacity)offices.add(estate);
            }
        }
        return offices;
    }

    @Override
    public MyListImpl getAps_in_Apscomplex_sortedfloor(String name_of_AC) {
        MyListImpl apartments = new MyListImpl();
        for (Estate estate : list) {
            if (estate.getClass().equals(Apartment.class)) {
                if(((Apartment) estate).getName_of_AC().equals(name_of_AC))apartments.add(estate);
            }
        }
        return apartments;
    }

    @Override
    public MyListImpl getOffices_in_businesscenter_sortedcapacity(String name_of_BC) {
        MyListImpl offices = new MyListImpl();
        for (Estate estate : list) {
            if (estate.getClass().equals(Office.class)) {
                if(((Office) estate).getName_of_BC().equals(name_of_BC))offices.add(estate);
            }
        }
        return offices;
    }

    @Override
    public MyListImpl getOffices_in_district(String district_name) {
        MyListImpl offices = new MyListImpl();
        for (Estate estate : list) {
            if (estate.getClass().equals(Office.class)) {
                if(estate.getCity_district().equals(district_name))offices.add(estate);
            }
        }
        return offices;
    }

    @Override
    public MyListImpl getApartments_in_district(String district_name) {
        MyListImpl apartments = new MyListImpl();
        for (Estate estate : list) {
            if (estate.getClass().equals(Apartment.class)) {
                if(estate.getCity_district().equals(district_name))apartments.add(estate);
            }
        }
        return apartments;
    }
}