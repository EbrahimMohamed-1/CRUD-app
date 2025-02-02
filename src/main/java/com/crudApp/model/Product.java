package com.crudApp.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotEmpty(message = "this field can not be empty")
    @Column(nullable = false)
    String name;

    @OneToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinColumn
    ProductDetails productDetails;



}
