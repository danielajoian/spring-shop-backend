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
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name = "user_email_unique", columnNames = "email")
})
public class User {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private long id;

    @Email @NotNull
    private String email;

    @NotNull @Size(min = 7, max = 15)
    private String phone;

    @NotNull @Size(min = 3, max = 20)
    private String firstName;

    @NotNull @Size(min = 3, max = 20)
    private String lastName;

    @NotNull @Size(min = 3, max = 20)
    private String password;

    @NotNull @Size(min = 3, max = 20) @Transient
    private String confirmPassword;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties( value = { "user" })
    List<Product> products;
}
