package labwork.holik.maksym.lab5.Form;

public class GetOfficesByBusinessCenterForm {
    private String name_of_BC;

    public GetOfficesByBusinessCenterForm(String name_of_BC) {
        this.name_of_BC = name_of_BC;
    }

    public GetOfficesByBusinessCenterForm() {
    }

    public String getName_of_BC() {
        return name_of_BC;
    }

    public void setName_of_BC(String name_of_BC) {
        this.name_of_BC = name_of_BC;
    }
}
