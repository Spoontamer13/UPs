package com.example.api_yp.Controllers;

import com.example.api_yp.Models.Person;
import com.example.api_yp.Models.PersonShop;
import com.example.api_yp.Models.Shop;
import com.example.api_yp.Repositories.PersonRepository;
import com.example.api_yp.Repositories.PersonShopRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PesonShopController {
    @Autowired
    private PersonShopRepository personShopRepository;
    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/searchOrder")
    public ResponseEntity<List<PersonShop>> searchOrder(@Valid @RequestBody Person person) {
        Person personFromDB = personRepository.findUserByUsername(person.getUsername());
        if (personFromDB == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<PersonShop> personShops = personShopRepository.findPersonShopByPerson(personFromDB.getIdPerson());

        return new ResponseEntity<>(personShops, HttpStatus.OK);
    }

    @GetMapping("/personShop/{idPersonShop}")
    public ResponseEntity<PersonShop> onePersonShop(@PathVariable Long idPersonShop) {
        Optional<PersonShop> optionalPersonShop = personShopRepository.findById(idPersonShop);

        if (optionalPersonShop.isPresent()) {
            return new ResponseEntity<>(optionalPersonShop.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/personShop")
    public ResponseEntity<PersonShop> createPersonShop(@Valid @RequestBody PersonShop personShopRequest) {
        PersonShop personShop = personShopRepository.save(personShopRequest);

        return new ResponseEntity<>(personShop, HttpStatus.CREATED);
    }

    @PutMapping("/personShop/{idPersonShop}")
    public ResponseEntity<PersonShop> updatePersonShop(@PathVariable Long idPersonShop,
                                           @Valid @RequestBody PersonShop personShopRequest) {
        Optional<PersonShop> optionalPersonShop = personShopRepository.findById(idPersonShop);

        if (optionalPersonShop.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        PersonShop personShop = optionalPersonShop.get();

        personShop.setIdPersonShop(personShopRequest.getIdPersonShop());
        personShop.setProduct(personShopRequest.getProduct());
        personShop.setPerson(personShopRequest.getPerson());

        PersonShop personShopUpdate = personShopRepository.save(personShop);

        return new ResponseEntity<>(personShopUpdate, HttpStatus.OK);
    }


    @DeleteMapping("/personShop/{idPersonShop}")
    public ResponseEntity<?> deletePersonShop(@PathVariable Long idPersonShop) {
        Optional<PersonShop> optionalPersonShop = personShopRepository.findById(idPersonShop);

        if (optionalPersonShop.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        PersonShop personShop = optionalPersonShop.get();

        personShopRepository.delete(personShop);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
