package labwork.holik.maksym.lab2;

import java.util.Arrays;
import java.util.Objects;

abstract public class Estate implements Comparable<Estate>{
    protected String name;
    protected String city_district;
    protected double area;
    protected int []date_of_build;
    ///////////////////////////////////

    public Estate(String name, String city_district, double area, int[]date_of_build){
        this.name=name;
        this.city_district = city_district;
        this.area=area;
        this.date_of_build=new int[3];
        this.date_of_build=date_of_build.clone();
    }

    @Override
    public String toString() {
        return "Тип объекта недвижимости: " + name + " Район расположения: "+city_district+ ", Площадь объекта: " + area +
                " (м.кв), Дата окончания постройки: " + Arrays.toString(date_of_build) + '\n';
    }

    public String toStringDate(){
        return date_of_build[0]+"-"+date_of_build[1]+"-"+date_of_build[2];
    }

     @Override
     public int compareTo(Estate o) {
        int flag;
        if(this.area==o.area)flag=0;
        else flag= this.area<o.area? -1:1;
        if(flag==0){
            if(Arrays.equals(this.date_of_build,o.date_of_build))return flag;
            else {
                flag = this.date_of_build[2] < o.date_of_build[2] ? -1 : 1;
                if (this.date_of_build[2] == o.date_of_build[2]) {
                    flag = this.date_of_build[1] < o.date_of_build[1] ? -1 : 1;
                    if (date_of_build[1] == o.date_of_build[1]) {
                        flag = this.date_of_build[0] < o.date_of_build[0] ? -1 : 1;
                    }
                }
            }
        }
        return flag;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estate estate = (Estate) o;
        return Double.compare(estate.area, area) == 0 && name.equals(estate.name) && Arrays.equals(date_of_build, estate.date_of_build);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, area);
        result = 31 * result + Arrays.hashCode(date_of_build);
        return result;
    }

    public String getName() {
        return name;
    }

    public String getCity_district() {
        return city_district;
    }

    public double getArea() {
        return area;
    }

    public int[] getDate_of_build() {
        return date_of_build;
    }

    public Estate() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity_district(String city_district) {
        this.city_district = city_district;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setDate_of_build(int[] date_of_build) {
        this.date_of_build = date_of_build;
    }
}
