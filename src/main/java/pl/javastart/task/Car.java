package pl.javastart.task;

public class Car {
    private String type;
    private String make;
    private String model;
    private int productionYear;
    private int mileage;
    private String vin;

    public Car(String type, String make, String model, int productionYear, int mileage, String vin) {
        this.type = type;
        this.make = make;
        this.model = model;
        this.productionYear = productionYear;
        this.mileage = mileage;
        this.vin = vin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Pojazd: " + type + " " + make + " " + model + " (" + productionYear + "), przebieg "
                + mileage + "km, nr VIN: " + vin;
    }

    public String toCsv() {
        return type + ";" + make + ";" + model + ";" + productionYear + ";" + mileage + ";" + vin;
    }
}
