package labwork.holik.maksym.lab2;

import java.util.Objects;

abstract public class Residental extends Estate{
    protected int purchase_price;
    protected int rent_price;
    protected int rooms;
    public Residental(String name,String city_district ,double area,int[]date_of_buildings, int purchase_price, int rent_price, int rooms){
        super(name, city_district,area,date_of_buildings);
        this.purchase_price=purchase_price;
        this.rent_price=rent_price;
        this.rooms=rooms;
    }

    public int getRooms() {
        return rooms;
    }

    @Override
    public String toString() {
        return super.toString()+" Стоимость покупки: " + purchase_price + ", Стоимость аренды: " + rent_price +
                ", Количество комнат: " + rooms + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Residental that = (Residental) o;
        return purchase_price == that.purchase_price && rent_price == that.rent_price && rooms == that.rooms;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), purchase_price, rent_price, rooms);
    }

    public int getPurchase_price() {
        return purchase_price;
    }

    public int getRent_price() {
        return rent_price;
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
}