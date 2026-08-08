package com.inexxinteractive.northwind.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data // lombok çağırır ve get set yazar
@Entity// anatsayon : bir classın derleme anaında bilgi toplma yapsısı
@Table(name="products")
@AllArgsConstructor//cunsrocteri ekleyen anatsayon
//buada paramterziz konsroketö
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

    @ManyToOne()
    @JoinColumn(name="category_id")
    private Category category;

    public Product(){

    }


}
