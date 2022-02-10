package labwork.holik.maksym.lab4.DAO;

import labwork.holik.maksym.lab2.Apartment;
import labwork.holik.maksym.lab2.Office;
import labwork.holik.maksym.lab3.MyListImpl;

import java.sql.*;

public class MySQLDAO implements IMyDAO{

    private static Connection connection;

    private static final String getALLapartments = "SELECT name, city_district, area, date_of_build, purchase_price, rent_price, rooms, name_of_AC, floor, separate_bathroom, balcony_area from apartments join apartments_complexes using (idcomplex) join city_districts using (iddistrict);";
    private static final String getALLoffices = "SELECT name, city_district, area, date_of_build, capacity, emergency_exits, parking, name_of_BC, conference_halls, negotiation_rooms, biometric_security from offices join business_centers using (idcenter) join city_districts using (iddistrict);";
    private static final String insertApartment = "INSERT INTO apartments (name,area,date_of_build,purchase_price,rent_price,rooms,idcomplex,floor,separate_bathroom,balcony_area) VALUES (?,?,?,?,?,?,?,?,?,?);";
    private static final String insertOffice = "INSERT INTO offices(name,area,date_of_build,capacity,emergency_exits,parking,idcenter,conference_halls,negotiation_rooms,biometric_security)VALUES(?,?,?,?,?,?,?,?,?,?);";
    private static  final String removeApartment = "DELETE FROM apartments WHERE name like ?";
    private static  final String removeOffice = "DELETE FROM offices WHERE name like ?";
    private static final String updateApartment = "UPDATE apartments SET area =?, purchase_price =?,rent_price= ?,rooms=?,separate_bathroom=?,balcony_area=?WHERE name like ?;";
    private static final String updateOffice = "UPDATE offices SET area=?,capacity=?,emergency_exits=?,parking=?,conference_halls=?,negotiation_rooms=?,biometric_security=? WHERE name like ?;";
    private static final String getAps_samedistrict_theOffice ="SELECT name, city_district, area, date_of_build, purchase_price, rent_price, rooms, name_of_AC, floor, separate_bathroom, balcony_area from apartments join apartments_complexes using (idcomplex) join city_districts using (iddistrict) where city_district=(select city_district from city_districts join business_centers using (iddistrict) join offices using (idcenter) where name=?)";
    private static final String getOffice_samedistrict_theAps = "SELECT name, city_district, area, date_of_build, capacity, emergency_exits, parking, name_of_BC, conference_halls, negotiation_rooms, biometric_security from offices join business_centers using (idcenter) join city_districts using (iddistrict) where city_district=(select city_district from city_districts join apartments_complexes using (iddistrict) join apartments using (idcomplex) where name=?)";
    private static final String getAps_by_purchase_range = "SELECT name, city_district, area, date_of_build, purchase_price, rent_price, rooms, name_of_AC, floor, separate_bathroom, balcony_area from apartments join apartments_complexes using (idcomplex) join city_districts using (iddistrict) where purchase_price between ? AND ? order by purchase_price";
    private static final String get_offices_where_capacity_greater_than_desc = "SELECT name, city_district, area, date_of_build, capacity, emergency_exits, parking, name_of_BC, conference_halls, negotiation_rooms, biometric_security from offices join business_centers using (idcenter) join city_districts using (iddistrict) where capacity>? order by capacity desc";
    private static final String getAps_in_Apscomplex_sortedfloor = "SELECT name, city_district, area, date_of_build, purchase_price, rent_price, rooms, name_of_AC, floor, separate_bathroom, balcony_area from apartments join apartments_complexes using (idcomplex) join city_districts using (iddistrict) where name_of_AC=? order by floor";
    private static final String getOffices_in_businesscenter_sortedcapacity = "SELECT name, city_district, area, date_of_build, capacity, emergency_exits, parking, name_of_BC, conference_halls, negotiation_rooms, biometric_security from offices join business_centers using (idcenter) join city_districts using (iddistrict) where name_of_BC=? order by capacity";
    private static final String getOffices_in_district = "SELECT name, city_district, area, date_of_build, capacity, emergency_exits, parking, name_of_BC, conference_halls, negotiation_rooms, biometric_security from offices join business_centers using (idcenter) join city_districts using (iddistrict) WHERE city_district LIKE ?";
    private static final String getApartments_in_district = "SELECT name, city_district, area, date_of_build, capacity, emergency_exits, parking, name_of_BC, conference_halls, negotiation_rooms, biometric_security from offices join business_centers using (idcenter) join city_districts using (iddistrict) WHERE city_district LIKE ?";
    public MySQLDAO (){
        try {
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab4?useUnicode=true&serverTimezone=UTC", "root", "56584");
        }
        catch (Exception e){
            e.printStackTrace();
        }
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
        MyListImpl list = new MyListImpl();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(getALLapartments);
            while (rs.next()) {
                list.add(new Apartment(rs.getString(1),rs.getString(2),rs.getDouble(3),dateToArray(rs.getString(4)),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getBoolean(10),rs.getDouble(11)));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public MyListImpl getALLoffices() {
        MyListImpl list = new MyListImpl();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(getALLoffices);
            while (rs.next()) {
                list.add(new Office(rs.getString(1),rs.getString(2),rs.getDouble(3),dateToArray(rs.getString(4)),rs.getInt(5),rs.getInt(6),rs.getBoolean(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getBoolean(11)));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insertApartment(String name,double area,String d_of_b,int purchase,int rent,int rooms,int idCOMP,int floor, boolean sepWC, double balcony){
        try{
            PreparedStatement pst =connection.prepareStatement(insertApartment);
            pst.setString(1,name);
            pst.setDouble(2,area);
            pst.setString(3,d_of_b);
            pst.setInt(4,purchase);
            pst.setInt(5,rent);
            pst.setInt(6,rooms);
            pst.setInt(7,idCOMP);
            pst.setInt(8,floor);
            pst.setBoolean(9,sepWC);
            pst.setDouble(10,balcony);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertOffice(String name, double area, String d_of_b, int cap, int em_ex, boolean park, int idCEN, int con_h, int neg_r, boolean b_sec) {
        try{
            PreparedStatement pst =connection.prepareStatement(insertOffice);
            pst.setString(1,name);
            pst.setDouble(2,area);
            pst.setString(3,d_of_b);
            pst.setInt(4,cap);
            pst.setInt(5,em_ex);
            pst.setBoolean(6,park);
            pst.setInt(7,idCEN);
            pst.setInt(8,con_h);
            pst.setInt(9,neg_r);
            pst.setBoolean(10,b_sec);
            pst.executeUpdate();
            pst.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeApartment(String name) {
        try{
            PreparedStatement pst = connection.prepareStatement(removeApartment);
            pst.setString(1,name);
            pst.executeUpdate();
            pst.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeOffice(String name) {
        try{
            PreparedStatement pst = connection.prepareStatement(removeOffice);
            pst.setString(1,name);
            pst.executeUpdate();
            pst.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateApartment(String name,double area,int purchase,int rent,int rooms,boolean sepWC,double balcony) {
        try {
            PreparedStatement pst = connection.prepareStatement(updateApartment);
            pst.setDouble(1,area);
            pst.setInt(2,purchase);
            pst.setInt(3,rent);
            pst.setInt(4,rooms);
            pst.setBoolean(5,sepWC);
            pst.setDouble(6,balcony);
            pst.setString(7,name);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateOffice(String name, double area, int cap, int em_ex, boolean park, int con_h, int neg_r, boolean b_sec) {
        try{
            PreparedStatement pst = connection.prepareStatement(updateOffice);
            pst.setDouble(1,area);
            pst.setInt(2,cap);
            pst.setInt(3,em_ex);
            pst.setBoolean(4,park);
            pst.setInt(5,con_h);
            pst.setInt(6,neg_r);
            pst.setBoolean(7,b_sec);
            pst.setString(8,name);
            pst.executeUpdate();
            pst.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public MyListImpl getAps_samedistrict_theOffice(String OfficeName) {
        MyListImpl list = new MyListImpl();
        try{
            PreparedStatement pst = connection.prepareStatement(getAps_samedistrict_theOffice);
            pst.setString(1,OfficeName);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Apartment(rs.getString(1),rs.getString(2),rs.getDouble(3),dateToArray(rs.getString(4)),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getBoolean(10),rs.getDouble(11)));
            }
            rs.close();
            pst.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public MyListImpl getOffices_samedistrict_theAps(String ApsName) {
        MyListImpl list = new MyListImpl();
        try{
            PreparedStatement pst = connection.prepareStatement(getOffice_samedistrict_theAps);
            pst.setString(1,ApsName);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Office(rs.getString(1),rs.getString(2),rs.getDouble(3),dateToArray(rs.getString(4)),rs.getInt(5),rs.getInt(6),rs.getBoolean(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getBoolean(11)));
            }
            rs.close();
            pst.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public MyListImpl getAps_by_purchase_range(int min, int max) {
        MyListImpl list = new MyListImpl();
        try{
            PreparedStatement pst = connection.prepareStatement(getAps_by_purchase_range);
            pst.setInt(1,min);
            pst.setInt(2,max);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Apartment(rs.getString(1),rs.getString(2),rs.getDouble(3),dateToArray(rs.getString(4)),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getBoolean(10),rs.getDouble(11)));
            }
            rs.close();
            pst.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public MyListImpl getOffices_where_capacity_greater_than_desc(int capacity) {
        MyListImpl list = new MyListImpl();
        try{
            PreparedStatement pst = connection.prepareStatement(get_offices_where_capacity_greater_than_desc);
            pst.setInt(1,capacity);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Office(rs.getString(1),rs.getString(2),rs.getDouble(3),dateToArray(rs.getString(4)),rs.getInt(5),rs.getInt(6),rs.getBoolean(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getBoolean(11)));
            }
            rs.close();
            pst.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public MyListImpl getAps_in_Apscomplex_sortedfloor(String name_of_AC) {
        MyListImpl list = new MyListImpl();
        try{
            PreparedStatement pst = connection.prepareStatement(getAps_in_Apscomplex_sortedfloor);
            pst.setString(1,name_of_AC);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Apartment(rs.getString(1),rs.getString(2),rs.getDouble(3),dateToArray(rs.getString(4)),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getBoolean(10),rs.getDouble(11)));
            }
            rs.close();
            pst.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public MyListImpl getOffices_in_businesscenter_sortedcapacity(String name_of_BC) {
        MyListImpl list = new MyListImpl();
        try{
            PreparedStatement pst = connection.prepareStatement(getOffices_in_businesscenter_sortedcapacity);
            pst.setString(1,name_of_BC);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Office(rs.getString(1),rs.getString(2),rs.getDouble(3),dateToArray(rs.getString(4)),rs.getInt(5),rs.getInt(6),rs.getBoolean(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getBoolean(11)));
            }
            rs.close();
            pst.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public MyListImpl getOffices_in_district(String district_name) {
        MyListImpl list = new MyListImpl();
        try{
            PreparedStatement pst = connection.prepareStatement(getOffices_in_district);
            pst.setString(1,district_name);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Office(rs.getString(1),rs.getString(2),rs.getDouble(3),dateToArray(rs.getString(4)),rs.getInt(5),rs.getInt(6),rs.getBoolean(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getBoolean(11)));
            }
            rs.close();
            pst.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public MyListImpl getApartments_in_district(String district_name) {
        MyListImpl list = new MyListImpl();
        try{
            PreparedStatement pst = connection.prepareStatement(getApartments_in_district);
            pst.setString(1,district_name);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Apartment(rs.getString(1),rs.getString(2),rs.getDouble(3),dateToArray(rs.getString(4)),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getBoolean(10),rs.getDouble(11)));
            }
            rs.close();
            pst.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}