package lab.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
public class UsualPerson implements Person {
    @Id
    @Column
    int id;

    @Column
    @Accessors(chain = false)
    String name;

    @Getter(AccessLevel.NONE)
    int age;

    @Getter(AccessLevel.NONE)
    float height;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    Country country;

    boolean isProgrammer;
    List<String> contacts;

    @Override
    public void sayHello(Person person) {
    }
}