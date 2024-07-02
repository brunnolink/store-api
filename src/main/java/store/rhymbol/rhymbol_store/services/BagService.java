package store.rhymbol.rhymbol_store.services;

import org.springframework.stereotype.Service;
import store.rhymbol.rhymbol_store.domain.Bag;
import store.rhymbol.rhymbol_store.domain.Item;
import store.rhymbol.rhymbol_store.dto.item.ItemDTO;

@Service
public interface BagService {

    Item includeItem(ItemDTO itemDTO);
    Bag bagDetails(Long id);

    Bag closeBag(Long id, int paymentForm);
}
