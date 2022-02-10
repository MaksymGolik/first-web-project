package labwork.holik.maksym.lab5.Form;

public class DeleteOfficeForm {
    private String officeName;

    public DeleteOfficeForm(String officeName) {
        this.officeName = officeName;
    }

    public DeleteOfficeForm() {
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }
}
