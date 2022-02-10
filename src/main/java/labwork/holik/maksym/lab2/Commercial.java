package labwork.holik.maksym.lab2;

import java.util.Objects;

abstract public class Commercial extends Estate{
    protected int capacity;
    protected int emergency_exits; // number of emergency exits;
    boolean parking; // parking availability
    public Commercial(String name, String city_district, double area, int[]date_of_build,int capacity, int emergency_exits, boolean parking){
        super(name, city_district, area,date_of_build);
        this.capacity=capacity;
        this.emergency_exits=emergency_exits;
        this.parking=parking;
    }

    @Override
    public String toString() {
        return super.toString() + "Вместимость: " + capacity + " (чел.) , Количество аварийных выходов: " + emergency_exits +
                ", Наличие паркинга: " + parking + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Commercial that = (Commercial) o;
        return capacity == that.capacity && emergency_exits == that.emergency_exits && parking == that.parking;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity, emergency_exits, parking);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEmergency_exits() {
        return emergency_exits;
    }

    public boolean isParking() {
        return parking;
    }

    public Commercial(String name, String city_district, double area, int[] date_of_build) {
        super(name, city_district, area, date_of_build);
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setEmergency_exits(int emergency_exits) {
        this.emergency_exits = emergency_exits;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }
}
