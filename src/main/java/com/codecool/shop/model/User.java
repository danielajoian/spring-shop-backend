package com.codecool.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    private long id;
    private String email;
    private String phone;
    private String name;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties( value = { "user" })
    List<Product> products;
}
