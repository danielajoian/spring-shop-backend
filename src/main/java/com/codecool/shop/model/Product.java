package com.codecool.shop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Product {

    @Id @GeneratedValue
    private long id;

    @NotNull
    @Size(min = 4, max = 30)
    private String title;

    @NotNull
    @Size(min = 4, max = 100)
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    @NotNull
    @Min(value = 1)
    private int price;

    private String imageLink;

    @NotNull
    @ManyToOne
    @JsonIgnoreProperties( value = { "products" })
    private User user;

}
