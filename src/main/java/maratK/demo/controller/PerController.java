package maratK.demo.controller;

import maratK.demo.entity.Person;
import maratK.demo.entity.PersonId;
import maratK.demo.repository.PerRepository;
import maratK.demo.service.PersonDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/persons")
@RestController
public class PerController {
    private static final String SAVE = "/add-person";
    private static final String SAVE_ALL = "/add-persons";
    private static final String FIND_BY_ID = "/find-by-id";
    private static final String EXISTS_BY_ID = "/exists-by-id";
    private static final String FIND_ALL = "/find-all";
    private static final String FIND_ALL_BY_ID = "/find-all-by-id";
    private static final String COUNT = "/count";
    private static final String DELETE_BY_ID = "/delete-by-id";
    private static final String DELETE_PERSON = "/delete-person";
    private static final String DELETE_ALL_PERSONS = "/delete-all-persons";
    private static final String DELETE_ALL = "/delete-all";

    private static final String FIND_BY_CITY = "/find-by-city";
    private static final String FIND_BY_AGE = "/find-by-age";
    private static final String FIND_BY_FULL_NAME = "/find-by-full-name";

    private final PersonDataService personDataService;

    public PerController(PersonDataService personDataService) {
        this.personDataService = personDataService;
    }

    @PostMapping(SAVE)
    public Person save(@RequestBody Person person) {
        return personDataService.save(person);
    }

    @PostMapping(SAVE_ALL)
    public List<Person> saveAll(@RequestBody List<Person> persons) {
        return personDataService.saveAll(persons);
    }

    @GetMapping(FIND_BY_ID)
    public Person findById(PersonId personId) {
        return personDataService.findById(personId);
    }

    @GetMapping(EXISTS_BY_ID)
    public String existsById(PersonId personId) {
        return personDataService.existsById(personId);
    }

    @GetMapping(FIND_ALL)
    public List<Person> findAll() {
        return personDataService.findAll();
    }

    @GetMapping(FIND_ALL_BY_ID)
    public List<Person> findAllById(List<PersonId> personIdList) {
        return personDataService.findAllById(personIdList);
    }

    @GetMapping(COUNT)
    public String count() {
        return personDataService.count();
    }

    @PostMapping(DELETE_BY_ID)
    public void deleteById(PersonId personId) {
        personDataService.deleteById(personId);
    }

    @PostMapping(DELETE_PERSON)
    public void setDeletePerson(@RequestBody Person person) {
        personDataService.delete(person);
    }

    @PostMapping(DELETE_ALL_PERSONS)
    public void deleteAllPersons(List<Person> personList) {
        personDataService.deleteAll(personList);
    }

    @PostMapping(DELETE_ALL)
    public void deleteAll() {
        personDataService.deleteAll();
    }


    @GetMapping(FIND_BY_CITY)
    public List<Person> readByCityOfLiving(@RequestParam String city) {
        return personDataService.findAllByCityOfLiving(city);
    }

    @GetMapping(FIND_BY_AGE)
    public List<Person> readByAge(@RequestParam int age) {
        return personDataService.findAllByAge(age);
    }

    @GetMapping(FIND_BY_FULL_NAME)
    public List<Person> readByAge(@RequestParam String name, @RequestParam String surname) {
        return personDataService.findAllByNameAndSurname(name,surname);
    }
}