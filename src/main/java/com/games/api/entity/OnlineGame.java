package com.games.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "online_games")
public class OnlineGame extends GameBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_online_game")
    private Long id;

    @Column(name = "server", length = 100)
    private String server;

    @Column(name = "multiplayer")
    private Boolean multiplayer;

    @Column(name = "subscription_period", length = 50)
    private String subscriptionPeriod;

    @Column(name = "max_players")
    private Integer maxPlayers;
}

