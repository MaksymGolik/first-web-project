package labwork.holik.maksym.lab2;

import java.util.Objects;

public class Detached_House extends Residental{
    protected double land_area;
    int number_of_floors;
    boolean pool;
    public Detached_House(String name,String city_district,double area,int[]date_of_buildings, int purchase_price, int rent_price,
                          int rooms,double land_area, int number_of_floors,boolean pool){
        super(name,city_district,area,date_of_buildings,purchase_price,rent_price,rooms);
        this.land_area=land_area;
        this.number_of_floors=number_of_floors;
        this.pool=pool;
    }

    @Override
    public String toString() {
        return super.toString() + "Площадь прилегающей территории: " + land_area + " (м.кв), " +
                "Количество этажей: " + number_of_floors +
                ", Наличие бассейна: " + pool + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Detached_House that = (Detached_House) o;
        return Double.compare(that.land_area, land_area) == 0 && number_of_floors == that.number_of_floors && pool == that.pool;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), land_area, number_of_floors, pool);
    }

    public double getLand_area() {
        return land_area;
    }

    public void setLand_area(double land_area) {
        this.land_area = land_area;
    }

    public int getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(int number_of_floors) {
        this.number_of_floors = number_of_floors;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }
}
