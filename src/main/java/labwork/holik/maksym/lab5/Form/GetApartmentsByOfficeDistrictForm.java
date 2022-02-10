package labwork.holik.maksym.lab5.Form;

public class GetApartmentsByOfficeDistrictForm {
    private String OfficeName;

    public GetApartmentsByOfficeDistrictForm(String OfficeName){
        this.OfficeName = OfficeName;
    }

    public GetApartmentsByOfficeDistrictForm(){}

    public String getOfficeName() {
        return OfficeName;
    }

    public void setOfficeName(String officeName) {
        OfficeName = officeName;
    }
}
