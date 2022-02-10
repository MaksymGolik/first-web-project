package labwork.holik.maksym.lab5.Form;

public class GetOfficesByCapacityGreaterThanForm {
    private int mincapacity;

    public GetOfficesByCapacityGreaterThanForm(int mincapacity) {
        this.mincapacity = mincapacity;
    }

    public GetOfficesByCapacityGreaterThanForm() {
    }

    public int getMincapacity() {
        return mincapacity;
    }

    public void setMincapacity(int mincapacity) {
        this.mincapacity = mincapacity;
    }
}
