package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Orders")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ProductId;

    @NotNull
    private String ProductName;
    @NotNull
    private double ProductPrice;
    @NotNull
    private String ProductBrand;

    @NotNull
    private int StockQuantity;

    @NotNull
    private String Description;

    @NotNull
    private String ProductImage;


    // Setters

    public void setProductId(long ProductId) {
        this.ProductId = ProductId;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setProductPrice(double ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public void setProductBrand(String ProductBrand) {
        this.ProductBrand = ProductBrand;
    }

    public void setStockQuantity(int StockQuantity) {
        this.StockQuantity = StockQuantity;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setProductImage(String ProductImage) {
        this.ProductImage = ProductImage;
    }


    // Getters

    public long getProductId() {
        return this.ProductId;
    }

    public String getProductName() {
        return this.ProductName;
    }

    public double getProductPrice() {
        return this.ProductPrice;
    }

    public String getProductBrand() {
        return this.ProductBrand;
    }

    public int getStockQuantity() {
        return this.StockQuantity;
    }

    public String getDescription() {
        return this.Description;
    }

    public String getProductImage() {
        return this.ProductImage;
    }
}