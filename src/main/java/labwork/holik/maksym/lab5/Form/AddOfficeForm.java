package labwork.holik.maksym.lab5.Form;

public class AddOfficeForm {
    private String name;
    private double area;
    private String date_of_build;
    private int capacity;
    private int emergency_exits;
    private boolean parking;
    private int idCenter;
    private int conference_halls;
    private int negotiation_rooms;
    private boolean biometric_security;

    public AddOfficeForm() {
    }

    public AddOfficeForm(String name, double area, String date_of_build, int capacity, int emergency_exits, boolean parking, int idCenter, int conference_halls, int negotiation_rooms, boolean biometric_security) {
        this.name = name;
        this.area = area;
        this.date_of_build = date_of_build;
        this.capacity = capacity;
        this.emergency_exits = emergency_exits;
        this.parking = parking;
        this.idCenter = idCenter;
        this.conference_halls = conference_halls;
        this.negotiation_rooms = negotiation_rooms;
        this.biometric_security = biometric_security;
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

    public String getDate_of_build() {
        return date_of_build;
    }

    public void setDate_of_build(String date_of_build) {
        this.date_of_build = date_of_build;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getEmergency_exits() {
        return emergency_exits;
    }

    public void setEmergency_exits(int emergency_exits) {
        this.emergency_exits = emergency_exits;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public int getIdCenter() {
        return idCenter;
    }

    public void setIdCenter(int idCenter) {
        this.idCenter = idCenter;
    }

    public int getConference_halls() {
        return conference_halls;
    }

    public void setConference_halls(int conference_halls) {
        this.conference_halls = conference_halls;
    }

    public int getNegotiation_rooms() {
        return negotiation_rooms;
    }

    public void setNegotiation_rooms(int negotiation_rooms) {
        this.negotiation_rooms = negotiation_rooms;
    }

    public boolean isBiometric_security() {
        return biometric_security;
    }

    public void setBiometric_security(boolean biometric_security) {
        this.biometric_security = biometric_security;
    }
}
