package store.rhymbol.rhymbol_store.domain.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import store.rhymbol.rhymbol_store.domain.bag.Bag;
import store.rhymbol.rhymbol_store.domain.product.Product;

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
