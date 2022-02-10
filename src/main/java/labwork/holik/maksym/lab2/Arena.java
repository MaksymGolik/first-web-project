package labwork.holik.maksym.lab2;

import java.util.Objects;

public class Arena extends Commercial {
    protected int sectors; // number of sectors
    protected int displays; // number of displays
    protected int dressing_rooms; // number of dressing room
    protected boolean feeding_area;
    public Arena(String name, String city_district, double area, int[] date_of_build, int capacity, int emergency_exits, boolean parking,int sectors,
                 int displays,int dressing_rooms,boolean feeding_area){
        super(name, city_district, area, date_of_build, capacity, emergency_exits, parking);
        this.sectors=sectors;
        this.displays=displays;
        this.dressing_rooms=dressing_rooms;
        this.feeding_area=feeding_area;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Количество секторов: " + sectors +
                ", Количество табло: " + displays +
                ", Количество раздевалок: " + dressing_rooms +
                ", Наличие зоны фудкорта: " + feeding_area + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Arena arena = (Arena) o;
        return sectors == arena.sectors && displays == arena.displays && dressing_rooms == arena.dressing_rooms && feeding_area == arena.feeding_area;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sectors, displays, dressing_rooms, feeding_area);
    }

    public int getSectors() {
        return sectors;
    }

    public void setSectors(int sectors) {
        this.sectors = sectors;
    }

    public int getDisplays() {
        return displays;
    }

    public void setDisplays(int displays) {
        this.displays = displays;
    }

    public int getDressing_rooms() {
        return dressing_rooms;
    }

    public void setDressing_rooms(int dressing_rooms) {
        this.dressing_rooms = dressing_rooms;
    }

    public boolean isFeeding_area() {
        return feeding_area;
    }

    public void setFeeding_area(boolean feeding_area) {
        this.feeding_area = feeding_area;
    }
}