package store.rhymbol.rhymbol_store.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import store.rhymbol.rhymbol_store.domain.Bag;
import store.rhymbol.rhymbol_store.domain.Item;
import store.rhymbol.rhymbol_store.dto.item.ItemDTO;
import store.rhymbol.rhymbol_store.enumeration.PaymentForm;
import store.rhymbol.rhymbol_store.repositories.BagRepository;
import store.rhymbol.rhymbol_store.services.BagService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BagServiceImpl implements BagService {
    private final BagRepository bagRepository;
    @Override
    public Item includeItem(ItemDTO itemDTO) {
        return null;
    }

    @Override
    public Bag bagDetails(Long id) {
       return bagRepository.findById(id).orElseThrow(
               () -> {
                   throw new RuntimeException("Essa sacola não existe!");
       }
       );
    }

    @Override
    public Bag closeBag(Long id, int paymentForm) {
        Bag bag = bagDetails(id);

        if(bag.getItens().isEmpty()) {
            throw new RuntimeException("Inclua itens na sacola!");
        }

        PaymentForm payment = paymentForm == 0 ? PaymentForm.MONEY : PaymentForm.CREDIT_CARD;

        bag.setPaymentForm(payment);
        bag.setClose(true);
        return bagRepository.save(bag);
    }
}
