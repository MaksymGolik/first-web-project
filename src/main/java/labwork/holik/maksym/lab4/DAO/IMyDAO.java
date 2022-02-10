package labwork.holik.maksym.lab4.DAO;

import labwork.holik.maksym.lab3.*;

public interface IMyDAO {
    MyListImpl getALLapartments();

    MyListImpl getALLoffices();

    void insertApartment(String name, double area, String d_of_b, int purchase, int rent, int rooms, int idCOMP, int floor, boolean sepWC, double balcony);

    void insertOffice(String name, double area, String d_of_b, int cap, int em_ex, boolean park, int idCEN, int con_h, int neg_r, boolean b_sec);

    void removeApartment(String name);

    void removeOffice(String name);

    void updateApartment(String name, double area, int purchase, int rent, int rooms, boolean sepWC, double balcony);

    void updateOffice(String name, double area, int cap, int em_ex, boolean park, int con_h, int neg_r, boolean b_sec);

    MyListImpl getAps_samedistrict_theOffice(String OfficeName);

    MyListImpl getOffices_samedistrict_theAps(String ApsName);

    MyListImpl getAps_by_purchase_range(int min, int max);

    MyListImpl getOffices_where_capacity_greater_than_desc(int capacity);

    MyListImpl getAps_in_Apscomplex_sortedfloor(String name_of_AC);

    MyListImpl getOffices_in_businesscenter_sortedcapacity(String name_of_BC);

    MyListImpl getOffices_in_district(String district_name);

    MyListImpl getApartments_in_district (String district_name);
}