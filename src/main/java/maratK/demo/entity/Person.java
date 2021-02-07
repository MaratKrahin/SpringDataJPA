package maratK.demo.entity;


import lombok.Data;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Persons")
public class Person {
    @EmbeddedId
    private PersonId personId;
    private String phoneNumber;
    private String cityOfLiving;

}
