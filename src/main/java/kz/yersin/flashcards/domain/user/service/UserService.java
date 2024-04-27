package kz.yersin.flashcards.domain.user.service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kz.yersin.flashcards.domain.user.model.User;
import kz.yersin.flashcards.domain.user.repository.UserRepository;
import kz.yersin.flashcards.infrastructure.exception.NotFoundException;
import kz.yersin.flashcards.infrastructure.exception.UsernameNotAvailableException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Yersin Mukay on 27.04.2024
 */
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public void validateUsernameForAvailable(final String username) {
        if (repository.findByUsername(username).isPresent()) {
            throw new UsernameNotAvailableException(username);
        }
    }

    public User findByUsername(final String username) {
        Optional<User> user = repository.findByUsername(username);
        return user.orElseThrow(() -> new NotFoundException("User not found with username: " + username));
    }

    public User findById(final Integer id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    }

    public void doHashAndSetPassword(@NotNull final User user, @NotBlank final String plainPassword) {
        user.setPassword(BCrypt.hashpw(plainPassword, BCrypt.gensalt()));
    }

    public User create(final User user) {
        return repository.save(user);
    }

    public User update(final User user) {
        return repository.save(user);
    }

    public void delete(final User user) {
        repository.delete(user);
    }

    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
