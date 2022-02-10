package labwork.holik.maksym.lab5.Form;

public class DeleteApartmentForm {
    private String apartmentName;

    public DeleteApartmentForm(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public DeleteApartmentForm() {
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }
}
