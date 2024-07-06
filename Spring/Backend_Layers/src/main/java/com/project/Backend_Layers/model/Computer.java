package com.project.Backend_Layers.model;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Computer {
    private String brand;
    private int rating;
    private int price;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Laptop{" +
                "rating=" + rating +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
