package lab.model;

import lombok.Value;

@Value
public class Country {
    static long serialVersionUID = 1L;
    String codeName;
    String name;
    int id;
}
