package uk.ac.westminster.products_api;

public interface Discountable {
    void applyDiscount(double rate);
    double getDiscountedPrice();
}
//both class compile because even though there is different code, the implementation/interface used is the same