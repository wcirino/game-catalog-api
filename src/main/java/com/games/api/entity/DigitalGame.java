package com.games.api.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "digital_games")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DigitalGame extends GameBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_digital_game")
    private Long id;

    @Column(name = "activation_key", length = 200)
    private String activationKey;

    @Column(name = "digital_store", length = 100)
    private String digitalStore;

    @Column(name = "download_size", precision = 6, scale = 2)
    private BigDecimal downloadSize;

    @Column(name = "license_expiration")
    private LocalDate licenseExpiration;
}

