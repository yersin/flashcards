package kz.yersin.flashcards.domain.desc.repository;

import kz.yersin.flashcards.domain.desc.model.Desc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Yersin Mukay on 27.04.2024
 */
public interface DescRepository extends JpaRepository<Desc, Integer> {

    List<Desc> findAllByUsername(String username);

}
