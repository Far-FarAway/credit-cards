package org.minibank.user.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Long id;
    @Column(nullable = false)
    String login;
    @Column(unique = true, nullable = false)
    @UniqueElements
    String email;
    @Column(nullable = false)
    String password;
    @Column(name = "birth_date", nullable = false)
    String birthDate;
}
