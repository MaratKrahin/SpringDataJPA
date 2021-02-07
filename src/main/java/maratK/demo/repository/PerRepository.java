package maratK.demo.repository;


import maratK.demo.entity.Person;
import maratK.demo.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PerRepository extends JpaRepository<Person, PersonId> {

    List<Person> findAllByCityOfLiving(String cityOfLiving);

    List<Person> findAllByPersonId_AgeGreaterThanOrderByPersonId_AgeAsc(int personId_age);

    Optional<List<Person>> findAllByPersonId_NameAndPersonId_Surname(String personId_name, String personId_surname);
}