package kz.yersin.flashcards.domain.desc.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * Created by Yersin Mukay on 27.04.2024
 */
@Entity
@Table(name = "descs")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Desc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(updatable = false, nullable = false, unique = true)
    private String username;

    private String title;
    private boolean enabled;

}
