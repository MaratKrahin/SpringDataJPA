package maratK.demo.entity;

import lombok.Data;
import javax.persistence.Embeddable;
import java.io.Serializable;



@Data
@Embeddable
public class PersonId implements Serializable {
    private String name;
    private String surname;
    private int age;
}