package com.crudApp.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@ToString

@Entity
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "this field can not be empty")
    @Column(nullable = false)
    private String name;

    @NotEmpty(message = "this field can not be empty")
    @Column(nullable = false)
    private String manufacturer;

    @NotNull(message = "This field can not be null")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;

    @Min(value = 1, message = "this field can not be less than one")
    @Column(nullable = false)
    private double price;

    @NotNull(message = "this field can not be null")
    @Column(nullable = false)
    private boolean available;

    //@NotEmpty(message = "this field can not be empty")
   // @Column(name = "img", columnDefinition = "longblob", nullable = false)
//    @Lob
//    private byte[] img;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "productDetails", cascade = CascadeType.ALL)
    private Product product;


}
