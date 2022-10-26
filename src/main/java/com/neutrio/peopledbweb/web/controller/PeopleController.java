package com.neutrio.peopledbweb.web.controller;

import com.neutrio.peopledbweb.biz.model.Person;
import com.neutrio.peopledbweb.data.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonRepository personRepository;

    private PeopleController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @ModelAttribute("people")
    public Iterable<Person> getPeople(){
        return personRepository.findAll();
    }

    @ModelAttribute
    public Person getPerson(){
        Person person = new Person();
        return person;
    }

    @GetMapping
    public String showPeoplePage(){
    return "people";
    }

    @PostMapping
    public String savePerson(@Valid Person person, Errors errors){
        if (!errors.hasErrors()) {
            personRepository.save(person);
            return "redirect:people";
        }
        return "people";
    }

    @PostMapping(params="delete=true")
    public String deletePeople(@RequestParam Optional<List<Long>> selections){
        if (selections.isPresent()) {
            personRepository.deleteAllById(selections.get());
        }
        return "redirect:people";
    }

    @PostMapping(params="edit=true")
    public String editPeople(@RequestParam Optional<List<Long>> selections, Model model){
        if (selections.isPresent()) {
            Optional<Person> person = personRepository.findById(selections.get().get(0));
            model.addAttribute("person", person);
        }
        return "people";
    }

}
