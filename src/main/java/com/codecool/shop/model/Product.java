package com.codecool.shop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Product {

    @Id @GeneratedValue
    private long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    private int price;
    private String imageLink;

    @ManyToOne
    @JsonIgnoreProperties( value = { "products" })
    private User user;

}
