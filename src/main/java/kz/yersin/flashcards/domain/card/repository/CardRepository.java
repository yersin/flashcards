package kz.yersin.flashcards.domain.card.repository;

import kz.yersin.flashcards.domain.card.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Yersin Mukay on 27.04.2024
 */
public interface CardRepository extends JpaRepository<Card, Integer> {

    List<Card> findAllByDescId(Integer descId);

}
