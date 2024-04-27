package kz.yersin.flashcards.domain.user.repository;

import kz.yersin.flashcards.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Yersin Mukay on 27.04.2024
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}
