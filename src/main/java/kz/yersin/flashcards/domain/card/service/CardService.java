package kz.yersin.flashcards.domain.card.service;

import kz.yersin.flashcards.domain.card.model.Card;
import kz.yersin.flashcards.domain.card.repository.CardRepository;
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
public class CardService {

    private final CardRepository repository;

    public List<Card> findAllByDescId(final Integer descId) {
        return repository.findAllByDescId(descId);
    }

    public Card findById(final Integer id) {
        Optional<Card> card = repository.findById(id);
        return card.orElseThrow(() -> new NotFoundException("Card not found with id: " + id));
    }

    public Card create(final Card card) {
        return repository.save(card);
    }

    public Card update(final Card card) {
        return repository.save(card);
    }

    public void delete(final Card card) {
        repository.delete(card);
    }

    public Page<Card> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
