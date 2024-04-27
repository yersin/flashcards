package kz.yersin.flashcards.domain.card.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * Created by Yersin Mukay on 27.04.2024
 */
@Entity
@Table(name = "cards")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(updatable = false, nullable = false, unique = true)
    private String username;

    @Column(updatable = false, nullable = false)
    private Integer descId;

    private String fontSideText;
    private String backSideText;

    private boolean enabled;

}
