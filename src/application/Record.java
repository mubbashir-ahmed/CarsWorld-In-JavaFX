package application;

import javafx.beans.property.SimpleStringProperty;

public class Record {
	private SimpleStringProperty brand;
	private SimpleStringProperty model;
	private SimpleStringProperty year;
	private SimpleStringProperty price;
	private SimpleStringProperty category;
	 
    public String getBrand() {
        return brand.get();
    }

    public String getModel() {
        return model.get();
    }

    public String getYear() {
        return year.get();
    }

    public String getPrice() {
        return price.get();
    }

    public String getCategory() {
        return category.get();
    }
    
    Record(String newbrand, String newmodel, String newcategory, String newyear, String newprice) {
        this.brand = new SimpleStringProperty(newbrand);
        this.model = new SimpleStringProperty(newmodel);
        this.category = new SimpleStringProperty(newcategory);
        this.year = new SimpleStringProperty(newyear);
        this.price = new SimpleStringProperty(newprice);
    }
}
