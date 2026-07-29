package com.inexxinteractive.northwind.entities.concretes;

import jakarta.persistence.*;
import lombok.Data;
@Entity// anatsayon : bir classın derleme anaında bilgi toplma yapsısı
@Table(name="products")
@Data // lombok çağırır ve get set yazar
public class Product  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// yeni ürürn ekeldğimzde örnek 5 . ID dolu bu anatsyon 6 dan devam eder bizi uğraştımaz
    // paraantezi içide işği sql burkaır AUTO_INCREMENT  özlleğii kullanır kayıt db ye gider o andkai ugun ıd yerleştirri
    @Column(name="product_id")                                  //111111111     11111112   11111113
    private int id;

    @Column(name="category_id")
    private int categoryId ;

    @Column(name="product_name")
    private  String productName;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="units_in_stock")
    private short unitsInStoc;

    @Column(name="quantity_per_unit")
    private  String quantityPerUnit;

    public Product(){

    }

    public Product(int id, String productName, int categoryId, double unitPrice, short unitsInStoc, String quantityPerUnit) {
        this.id = id;
        this.productName = productName;
        this.categoryId = categoryId;
        this.unitPrice = unitPrice;
        this.unitsInStoc = unitsInStoc;
        this.quantityPerUnit = quantityPerUnit;
    }
}
