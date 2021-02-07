package maratK.demo.service;

import maratK.demo.entity.Person;
import maratK.demo.entity.PersonId;
import maratK.demo.exception.NotFoundException;
import maratK.demo.repository.PerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDataService {
    private PerRepository perRepository;

    public PersonDataService(PerRepository perRepository) {
        this.perRepository = perRepository;
    }

    public Person save(Person person) {
        return perRepository.save(person);
    }

    public List<Person> saveAll(List<Person> personList) {
        return perRepository.saveAll(personList);
    }

    public Person findById(PersonId personId) {
        return perRepository.findById(personId)
                .orElseThrow(NotFoundException::new);
    }

    public String existsById(PersonId personId) {
        return perRepository.existsById(personId) ?
                "exists" : "not exists";
    }

    public List<Person> findAll() {
        return perRepository.findAll();
    }

    public List<Person> findAllById(List<PersonId> personIdList) {
        return perRepository.findAllById(personIdList);
    }

    public String count() {
        return Long.toString(perRepository.count());
    }

    public void deleteById(PersonId personId) {
        perRepository.deleteById(personId);
    }

    public void delete(Person person) {
        perRepository.delete(person);
    }

    public void deleteAll(List<Person> personList) {
        perRepository.deleteAll(personList);
    }

    public void deleteAll() {
        perRepository.deleteAll();
    }

    
    public List<Person> findAllByCityOfLiving(String cityOfLiving) {
        return perRepository.findAllByCityOfLiving(cityOfLiving);
    }

    public List<Person> findAllByAge(int age) {
        return perRepository
                .findAllByPersonId_AgeGreaterThanOrderByPersonId_AgeAsc(age);
    }

    public List<Person> findAllByNameAndSurname(String name, String surname) {
        return perRepository
                .findAllByPersonId_NameAndPersonId_Surname(name, surname)
                .orElseThrow(NotFoundException::new);
    }
}
