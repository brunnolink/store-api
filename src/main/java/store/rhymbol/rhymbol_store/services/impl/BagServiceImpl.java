package store.rhymbol.rhymbol_store.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import store.rhymbol.rhymbol_store.domain.Bag;
import store.rhymbol.rhymbol_store.domain.Item;
import store.rhymbol.rhymbol_store.domain.Restaurant;
import store.rhymbol.rhymbol_store.dto.item.ItemDTO;
import store.rhymbol.rhymbol_store.enumeration.PaymentForm;
import store.rhymbol.rhymbol_store.repositories.BagRepository;
import store.rhymbol.rhymbol_store.repositories.ItemRepository;
import store.rhymbol.rhymbol_store.repositories.ProductRepository;
import store.rhymbol.rhymbol_store.services.BagService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BagServiceImpl implements BagService {
    private final BagRepository bagRepository;
    private final ProductRepository productRepository;
    private final ItemRepository itemRepository;

    @Override
    public Item includeItem(ItemDTO itemDTO) {
        Bag bag = bagDetails(itemDTO.bagId());

        if (bag.isClose()) {
            throw new RuntimeException("Esta sacola está fechada.");
        }

        Item insertItem = Item.builder()
                .amount(itemDTO.amount())
                .bag(bag)
                .product(productRepository.findById(itemDTO.productId()).orElseThrow(
                        () -> {
                            throw new RuntimeException("Esse produto não existe!");
                        }
                ))
                .build();

        List<Item> bagItens = bag.getItens();
        if (bagItens.isEmpty()) {
            bagItens.add(insertItem);
        } else {
            Restaurant curentRestaurant = bagItens.get(0).getProduct().getRestaurant();

            Restaurant restaurantToAdd = insertItem.getProduct().getRestaurant();

            if (curentRestaurant.equals(restaurantToAdd)) {
                bagItens.add(insertItem);
            } else {
                throw new RuntimeException("Não é possível adicionar produtos de restaurante diferentes. Feche a sacola ou esvazie.");
            }
        }

        List<Double> itensValue = new ArrayList<>();

        for(Item bagItem : bagItens) {
           double totalValue = bagItem.getProduct().getUnitaryValue() * bagItem.getAmount();
            itensValue.add(totalValue);
        }

        double totalValueBag = itensValue.stream()
                .mapToDouble(eachValueItem -> eachValueItem)
                .sum();

        bag.setTotalValue(totalValueBag);
        bagRepository.save(bag);

        return insertItem;
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

        if (bag.getItens().isEmpty()) {
            throw new RuntimeException("Inclua itens na sacola!");
        }

        PaymentForm payment = paymentForm == 0 ? PaymentForm.MONEY : PaymentForm.CREDIT_CARD;

        bag.setPaymentForm(payment);
        bag.setClose(true);
        return bagRepository.save(bag);
    }
}
