package labwork.holik.maksym.lab5.Form;

public class AddApartmentForm {
    private String name;
    private double area;
    private String date_of_build;
    private int purchase_price;
    private int rent_price;
    private int rooms;
    private int idComplex;
    private int floor;
    private boolean separate_bathroom;
    private double balcony_area;

    public AddApartmentForm(String name, double area, String date_of_build, int purchase_price, int rent_price, int rooms, int idComplex, int floor, boolean separate_bathroom, double balcony_area) {
        this.name = name;
        this.area = area;
        this.date_of_build = date_of_build;
        this.purchase_price = purchase_price;
        this.rent_price = rent_price;
        this.rooms = rooms;
        this.idComplex = idComplex;
        this.floor = floor;
        this.separate_bathroom = separate_bathroom;
        this.balcony_area = balcony_area;
    }

    public AddApartmentForm() {
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public String getDate_of_build() {
        return date_of_build;
    }

    public int getPurchase_price() {
        return purchase_price;
    }

    public int getRent_price() {
        return rent_price;
    }

    public int getRooms() {
        return rooms;
    }

    public int getIdComplex() {
        return idComplex;
    }

    public int getFloor() {
        return floor;
    }

    public boolean getSeparate_bathroom() {
        return separate_bathroom;
    }

    public double getBalcony_area() {
        return balcony_area;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setDate_of_build(String date_of_build) {
        this.date_of_build = date_of_build;
    }

    public void setPurchase_price(int purchase_price) {
        this.purchase_price = purchase_price;
    }

    public void setRent_price(int rent_price) {
        this.rent_price = rent_price;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public void setIdComplex(int idComplex) {
        this.idComplex = idComplex;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setSeparate_bathroom(boolean separate_bathroom) {
        this.separate_bathroom = separate_bathroom;
    }

    public void setBalcony_area(double balcony_area) {
        this.balcony_area = balcony_area;
    }
}
