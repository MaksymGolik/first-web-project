package labwork.holik.maksym.lab5.Form;

public class GetApartmentsByPurchaseRangeForm {
    private int min;
    private int max;

    public GetApartmentsByPurchaseRangeForm(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public GetApartmentsByPurchaseRangeForm() {
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
