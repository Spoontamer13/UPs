package com.example.api_yp.Controllers;

import com.example.api_yp.Models.Person;
import com.example.api_yp.Models.Role;
import com.example.api_yp.Repositories.PersonRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;


    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder(8);
    }

    @PostMapping("/signUp")
    public ResponseEntity<Person> signUp(@Valid @RequestBody Person person) {
        Person personFromDB = personRepository.findUserByUsername(person.getUsername());
        if (personFromDB != null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        person.setRoles(Collections.singleton(Role.USER));
        person.setPassword(person.getPassword());
        person.setActive(true);
        personRepository.save(person);

        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PostMapping("/searchPerson")
    public ResponseEntity<Person> signIn(@Valid @RequestBody Person person) {
        Person personFromDB = personRepository.findUserByUsername(person.getUsername());
        if (personFromDB == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(personFromDB, HttpStatus.OK);
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getPerson() {
        List<Person> persons = personRepository.findAll();

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/person/{idPerson}")
    public ResponseEntity<Person> onePerson(@PathVariable Long idPerson) {
        Optional<Person> optionalPerson = personRepository.findById(idPerson);

        if (optionalPerson.isPresent()) {
            return new ResponseEntity<>(optionalPerson.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/roles")
    public ResponseEntity<Role[]> getRole() {

        return new ResponseEntity<>(Role.values(), HttpStatus.OK);
    }

    @PutMapping("/person/{idPerson}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long idPerson,
                                               @RequestBody String[] roles) {
        Optional<Person> personOptional = personRepository.findById(idPerson);

        if (personOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Person person = personOptional.get();
        person.getRoles().clear();
        if(roles != null)
        {
            for(String role: roles)
            {
                person.getRoles().add(Role.valueOf(role));
            }
        }

        Person personUpdate = personRepository.save(person);

        return new ResponseEntity<>(personUpdate, HttpStatus.OK);
    }
}
