package labwork.holik.maksym.lab2;

import java.util.Objects;

public class Apartment extends Residental{
    protected String name_of_AC; // apartment complex
    protected int floor;
    boolean separate_bathroom;
    double balcony_area;

    public String getName_of_AC() {
        return name_of_AC;
    }

    public int getFloor() {
        return floor;
    }

    public boolean isSeparate_bathroom() {
        return separate_bathroom;
    }

    public double getBalcony_area() {
        return balcony_area;
    }

    public Apartment(String name, String city_district, double area, int[]date_of_buildings, int purchase_price,
                     int rent_price, int rooms, String name_of_AC,
                     int floor, boolean separate_bathroom, double balcony_area){
        super(name,city_district,area,date_of_buildings,purchase_price,rent_price,rooms);
        this.name_of_AC=name_of_AC;
        this.floor=floor;
        this.separate_bathroom=separate_bathroom;
        this.balcony_area=balcony_area;
    }

    @Override
    public String toString() {
        return super.toString() + "Название ЖКХ: " + name_of_AC + ", Этаж: " + floor + ", Раздельный санузел: " +
                separate_bathroom + ", Площадь балкона: " + balcony_area + " (м.кв)\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apartment apartment = (Apartment) o;
        return floor == apartment.floor && separate_bathroom == apartment.separate_bathroom && Double.compare(apartment.balcony_area, balcony_area) == 0 && name_of_AC.equals(apartment.name_of_AC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name_of_AC, floor, separate_bathroom, balcony_area);
    }

    public void setName_of_AC(String name_of_AC) {
        this.name_of_AC = name_of_AC;
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
