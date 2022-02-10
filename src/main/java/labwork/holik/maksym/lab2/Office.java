package labwork.holik.maksym.lab2;

import java.util.Objects;

public class Office extends Commercial{
    protected String name_of_BC; // name of business center
    protected int conference_halls; // number of conference halls
    protected int negotiation_rooms; // number of negotiation rooms
    boolean biometric_security; // biometric security system available
    public Office(String name, String city_district, double area, int[]date_of_build,int capacity,
                  int emergency_exits, boolean parking,String name_of_BC,int conference_halls,
                  int negotiation_rooms,boolean biometric_security){
        super(name, city_district, area, date_of_build, capacity, emergency_exits, parking);
        this.name_of_BC = name_of_BC;
        this.conference_halls=conference_halls;
        this.negotiation_rooms=negotiation_rooms;
        this.biometric_security=biometric_security;
    }

    @Override
    public String toString() {
        return super.toString()+ "Название бизнес-центра: "+name_of_BC+" Количество конференц-залов: "+ conference_halls +
                ", Количество переговорных: " + negotiation_rooms +
                ", Наличие биометрической системы безопасности: " + biometric_security + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Office office = (Office) o;
        return conference_halls == office.conference_halls && negotiation_rooms == office.negotiation_rooms && biometric_security == office.biometric_security;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), conference_halls, negotiation_rooms, biometric_security);
    }

    public String getName_of_BC() {
        return name_of_BC;
    }

    public int getConference_halls() {
        return conference_halls;
    }

    public int getNegotiation_rooms() {
        return negotiation_rooms;
    }

    public boolean isBiometric_security() {
        return biometric_security;
    }

    public Office(String name, String city_district, double area, int[] date_of_build, int capacity, int emergency_exits, boolean parking) {
        super(name, city_district, area, date_of_build, capacity, emergency_exits, parking);
    }

    public void setName_of_BC(String name_of_BC) {
        this.name_of_BC = name_of_BC;
    }

    public void setConference_halls(int conference_halls) {
        this.conference_halls = conference_halls;
    }

    public void setNegotiation_rooms(int negotiation_rooms) {
        this.negotiation_rooms = negotiation_rooms;
    }

    public void setBiometric_security(boolean biometric_security) {
        this.biometric_security = biometric_security;
    }
}
