package store.rhymbol.rhymbol_store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import store.rhymbol.rhymbol_store.domain.Bag;


public interface BagRepository extends JpaRepository<Bag, Long> {
}
