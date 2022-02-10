package labwork.holik.maksym.lab5.Form;

public class UpdateApartmentForm {
    private String name;
    private double area;
    private int purchase_price;
    private int rent_price;
    private int rooms;
    private boolean separate_bathroom;
    private double balcony_area;

    public UpdateApartmentForm() {
    }

    public UpdateApartmentForm(String name, double area, int purchase_price, int rent_price, int rooms, boolean separate_bathroom, double balcony_area) {
        this.name = name;
        this.area = area;
        this.purchase_price = purchase_price;
        this.rent_price = rent_price;
        this.rooms = rooms;
        this.separate_bathroom = separate_bathroom;
        this.balcony_area = balcony_area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(int purchase_price) {
        this.purchase_price = purchase_price;
    }

    public int getRent_price() {
        return rent_price;
    }

    public void setRent_price(int rent_price) {
        this.rent_price = rent_price;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public boolean isSeparate_bathroom() {
        return separate_bathroom;
    }

    public void setSeparate_bathroom(boolean separate_bathroom) {
        this.separate_bathroom = separate_bathroom;
    }

    public double getBalcony_area() {
        return balcony_area;
    }

    public void setBalcony_area(double balcony_area) {
        this.balcony_area = balcony_area;
    }
}
