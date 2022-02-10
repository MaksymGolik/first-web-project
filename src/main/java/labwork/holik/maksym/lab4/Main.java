package labwork.holik.maksym.lab4;

import labwork.holik.maksym.lab3.MyListImpl;
import labwork.holik.maksym.lab4.DAO.*;

public class Main {
    public static void main(String[] args){
        try {
            //IMyDAO dao = DAOFactory.getDAOInstance(TypeDAO.MySQL);
            IMyDAO dao = DAOFactory.getDAOInstance(TypeDAO.COLLECTION);
            MyListImpl list = new MyListImpl();
            list = dao.getALLapartments();
            System.out.println(list);
//            list = dao.getALLoffices();
//            System.out.println(list);
//            dao.insertOffice("OFFICE584",400,"2015-4-3",750,6,true,4,3,6,true);
//            list = dao.getALLoffices();
//            System.out.println(list);
//            dao.updateOffice("OFFICE584",450,800,6,true,3,6,true);
//            list = dao.getALLoffices();
//            System.out.println(list);
//            dao.removeOffice("OFFICE584");
//            list = dao.getALLapartments();
//            System.out.println(list);
//            dao.insertApartment("APARTMENT-STUDIO",56.7,"2017-6-20",1345200,10111,3,2,7,true,4.7);
//            list = dao.getALLapartments();
//            System.out.println(list);
//            dao.updateApartment("APARTMENT-STUDIO", 56.7, 1400111, 10000, 3,true, 4.7);
//            list = dao.getALLapartments();
//            System.out.println(list);
//            dao.removeApartment("APARTMENT-STUDIO");
//
//            list = dao.getAps_samedistrict_theOffice("ECO-OFFICE");
//            System.out.println(list);
//            list = dao.getOffices_samedistrict_theAps("APARTMENT286");
//            System.out.println(list);
//            list = dao.getAps_by_purchase_range(799000,1400555);
//            System.out.println(list);
//            list = dao.getOffices_where_capacity_greater_than_desc(425);
//            System.out.println(list);
//            list = dao.getAps_in_Apscomplex_sortedfloor("Алексеевские акварели");
//            System.out.println(list);
//            list = dao.getOffices_in_businesscenter_sortedcapacity("AvePlaza");
//            System.out.println(list);
//            list = dao.getOffices_in_district("Шевченковский");
//            System.out.println(list);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
    }