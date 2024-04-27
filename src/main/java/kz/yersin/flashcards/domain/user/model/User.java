package kz.yersin.flashcards.domain.user.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * Created by Yersin Mukay on 27.04.2024
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(updatable = false, nullable = false, unique = true)
    private String username;

    private String fullName;
    private String password;
    private boolean enabled;

}
