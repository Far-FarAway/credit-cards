package org.minibank.creditCard.model;

import org.minibank.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.minibank.user.model.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "credit_cards")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User owner;
    @Column(nullable = false)
    @Builder.Default
    LocalDateTime duration = LocalDateTime.now().plusYears(5);
    @Column(nullable = false)
    @Builder.Default
    Status status = Status.ACTIVE;
    @Column(nullable = false)
    @Builder.Default
    int balance = 0;
}
