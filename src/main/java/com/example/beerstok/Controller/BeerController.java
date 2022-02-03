package com.example.beerstok.Controller;

import com.example.beerstok.service.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BeerController {
    @RestController
    @RequestMapping("/api/v1/beers")
    @AllArgsConstructor(onConstructor = @__(@Autowired))
    public static class BeerController implements BeerControllerDocs {

        private final BeerService beerService;
        private Object HttpStatus;

        @PostMapping
        @ResponseStatus(CREATED)
        public BeerDTO createBeer() throws BeerAlreadyRegisteredException {
            return createBeer();
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void createBeer(@RequestBody @Valid com.example.beerstok.dto.BeerDTO beerDTO) throws BeerAlreadyRegisteredException {
            BeerDTO BeerDTO;
            return beerService.createBeer(BeerDTO);
        }

        @GetMapping("/{name}")
        public BeerDTO findByName(@PathVariable String name) throws BeerNotFoundException {
            return beerService.findByName(name);
        }

        @GetMapping
        public List<BeerDTO> listBeers() {
            return beerService.listALL();
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteById(@PathVariable Long id) throws BeerNotFoundException {
            beerService.deleteById(id);
        }

        @PatchMapping("/{id}/increment")
        public BeerDTO increment(@PathVariable Long id, @RequestBody @Valid QuantityDTO quantityDTO) throws BeerNotFoundException, BeerStockExceededException {
            return beerService.increment(id, quantityDTO.getQuantity());
        }

}
