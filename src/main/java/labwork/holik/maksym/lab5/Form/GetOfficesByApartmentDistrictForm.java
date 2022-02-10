package labwork.holik.maksym.lab5.Form;

public class GetOfficesByApartmentDistrictForm {
    private String ApartmentName;
    public GetOfficesByApartmentDistrictForm(String ApartmentName){
        this.ApartmentName = ApartmentName;
    }

    public GetOfficesByApartmentDistrictForm(){}

    public String getApartmentName() {
        return ApartmentName;
    }

    public void setApartmentName(String apartmentName) {
        ApartmentName = apartmentName;
    }
}
