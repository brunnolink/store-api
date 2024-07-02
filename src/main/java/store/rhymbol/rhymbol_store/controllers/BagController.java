package store.rhymbol.rhymbol_store.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import store.rhymbol.rhymbol_store.domain.Bag;
import store.rhymbol.rhymbol_store.domain.Item;
import store.rhymbol.rhymbol_store.dto.item.ItemDTO;
import store.rhymbol.rhymbol_store.services.BagService;

@RestController
@RequestMapping("/rhymbol-store/bag")
@RequiredArgsConstructor
public class BagController {
    private final BagService bagService;

    @PostMapping
    public Item includeItem(@RequestBody ItemDTO itemDTO) {
        return bagService.includeItem(itemDTO);
    }
    @GetMapping("/{id}")
    public Bag bagDetail(@PathVariable("id") Long id ) {
        return bagService.bagDetails(id);
    }
    @PatchMapping("/closeBag/{bagId}")
    public Bag closeBag(@PathVariable("bagId") Long bagId, @RequestParam("paymentForm") int paymentForm ) {
        return bagService.closeBag(bagId, paymentForm);
    }
}
