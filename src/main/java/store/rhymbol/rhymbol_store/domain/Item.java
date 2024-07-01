package store.rhymbol.rhymbol_store.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import store.rhymbol.rhymbol_store.domain.Bag;
import store.rhymbol.rhymbol_store.domain.Product;

@Entity
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Product product;

    private int amount;

    @ManyToOne
    @JsonIgnore
    private Bag bag;
}
