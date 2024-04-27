package kz.yersin.flashcards.domain.desc.service;

import kz.yersin.flashcards.domain.desc.model.Desc;
import kz.yersin.flashcards.domain.desc.repository.DescRepository;
import kz.yersin.flashcards.infrastructure.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Yersin Mukay on 27.04.2024
 */
@Service
@AllArgsConstructor
public class DescService {

    private final DescRepository repository;

    public List<Desc> findAllByUsername(final String username) {
        return repository.findAllByUsername(username);
    }

    public Desc findById(final Integer id) {
        Optional<Desc> user = repository.findById(id);
        return user.orElseThrow(() -> new NotFoundException("Desc not found with id: " + id));
    }

    public Desc create(final Desc user) {
        return repository.save(user);
    }

    public Desc update(final Desc user) {
        return repository.save(user);
    }

    public void delete(final Desc user) {
        repository.delete(user);
    }

    public Page<Desc> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
