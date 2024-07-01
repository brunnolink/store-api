package store.rhymbol.rhymbol_store.domain.adress;


import jakarta.persistence.Embeddable;
import lombok.*;


@AllArgsConstructor
@Builder
@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class Adress {
    private String cep;
    private String complement;
}
