package model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsualPerson implements Person {
    @Id
    @Column
    int id;

    @Getter
    @Setter
    @Column
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
    public void sayHello(Person person) {}

}