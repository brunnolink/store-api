package store.rhymbol.rhymbol_store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.rhymbol.rhymbol_store.domain.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
