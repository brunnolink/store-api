package store.rhymbol.rhymbol_store.domain;


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
