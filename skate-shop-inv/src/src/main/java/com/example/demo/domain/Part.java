package com.example.demo.domain;

import com.example.demo.validators.ValidDeletePart;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 *
 *
 */
@Entity
@ValidDeletePart
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="part_type",discriminatorType = DiscriminatorType.INTEGER)
@Table(name="Parts")
public abstract class Part implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @Min(value = 0, message = "Price value must be positive")
    double price;
    @Min(value = 0, message = "Inventory must be positive")
    int inv;
    @Min(value = 0, message = "Inventory minimum value must be positive") // Ensure inventory minimum is positive
    int invMin;
    @Max(value = 500, message = "Inventory maximum value too large")
    @Min(value = 0, message = "Inventory maximum value must be positive") // Ensure inventory maximum is positive & <= 500
    int invMax;


    @ManyToMany
    @JoinTable(name="product_part", joinColumns = @JoinColumn(name="part_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))
    Set<Product> products= new HashSet<>();

    public Part() {
    }

    public Part(String name, double price, int inv) {
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.invMin = 0;
        this.invMax = 500;
    }

    public Part(long id, String name, double price, int inv) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.invMin = 0;
        this.invMax = 500;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInv() {
        return inv;
    }

    public void setInv(int inv) {
        this.inv = inv;
    }

    public int getInvMin() {return invMin;}

    public void setInvMin(int invMin) { this.invMin = invMin; }

    public int getInvMax() {return invMax;}

    public void setInvMax(int invMax) { this.invMax = invMax; }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String toString(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Part part = (Part) o;

        return id == part.id;
    }

    public void validateInvValue() {
        if (this.inv < this.invMin) {
            throw new RuntimeException("The inventory value is below the set minimum.");
        }
        if (this.inv > this.invMax) {
            throw new RuntimeException("The inventory value is above the set maximum.");
        }
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
