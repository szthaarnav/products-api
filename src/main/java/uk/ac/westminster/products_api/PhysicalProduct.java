package uk.ac.westminster.products_api;

//A PhysicalProduct IS-A Product because is acts as a type of  Product
//PhysicalProduct HAS-A Warehouse, it would not pass IS-A because it is not a type, it contains the thing inside
public class PhysicalProduct extends Product
implements Discountable{
    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct(){}
    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions){
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg(){
        return weightKg;
    }
    public String getDimensions(){
        return dimensions;
    }

    @Override
    public String getSummary(){
        return getName() + " Weight: "+getWeightKg();
    }

    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate,0.20);
        discountedPrice = getPrice() * (1-capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
