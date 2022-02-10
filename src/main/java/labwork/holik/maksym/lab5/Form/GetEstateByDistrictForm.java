package labwork.holik.maksym.lab5.Form;

public class GetEstateByDistrictForm {
    private String district_name;

    public GetEstateByDistrictForm(String district_name) {
        this.district_name = district_name;
    }

    public GetEstateByDistrictForm() {
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }
}
