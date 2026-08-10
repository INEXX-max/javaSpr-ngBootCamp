package com.inexxinteractive.northwind.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // lombok çağırır ve get set yazar
@Entity // anatsayon : bir classın derleme anaında bilgi toplma yapsısı
@Table(name="products")
@AllArgsConstructor // cunsrocteri ekleyen anatsayon
@NoArgsConstructor // Parametresiz constructor'ı otomatik ekler
public class Product  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private int id; // Yorum satırları kaldırıldı, hata önlendi!

    @Column(name="product_name")
    private String productName;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="units_in_stock")
    private short unitsInStock; // Eksik olan 'k' harfi eklendi

    @Column(name="quantity_per_unit")
    private String quantityPerUnit;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
}


