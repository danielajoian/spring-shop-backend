package com.codecool.shop.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Product {

    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
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

    private String dateOfTheAnnounce;

    @Getter
    private long timePassedSinceTheAnnounce;

    @ManyToOne
    @JsonIgnoreProperties( value = { "products" })
    private User user;

    public void calculateTimePassed() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateOfTheAnnounce, formatter);
        if(date != null) {
            timePassedSinceTheAnnounce = (ChronoUnit.DAYS
                    .between(date, LocalDate.now()));
        }
    }



}
