package store.rhymbol.rhymbol_store.domain.restaurant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import store.rhymbol.rhymbol_store.domain.adress.Adress;
import store.rhymbol.rhymbol_store.domain.product.Product;

import java.util.List;

@Entity
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> menu;
    @Embedded
    private Adress adress;
}
