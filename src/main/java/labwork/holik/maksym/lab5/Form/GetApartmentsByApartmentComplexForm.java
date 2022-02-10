package labwork.holik.maksym.lab5.Form;

public class GetApartmentsByApartmentComplexForm {
    private String name_of_AC;

    public GetApartmentsByApartmentComplexForm() {
    }

    public GetApartmentsByApartmentComplexForm(String name_of_AC) {
        this.name_of_AC = name_of_AC;
    }

    public String getName_of_AC() {
        return name_of_AC;
    }

    public void setName_of_AC(String name_of_AC) {
        this.name_of_AC = name_of_AC;
    }
}
