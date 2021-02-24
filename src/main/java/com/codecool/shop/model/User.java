package com.codecool.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private long id;

    @Email @NotNull
    private String email;

    @NotNull @Size(min = 7, max = 15)
    private String phone;

    @NotNull @Size(min = 4, max = 30)
    private String name;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties( value = { "user" })
    List<Product> products;
}
