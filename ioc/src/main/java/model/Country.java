package model;

import lombok.Value;
import java.io.Serializable;

@Value
public class Country implements Serializable {
    static long serialVersionUID = 1L;
    String codeName;
    String name;
    int id;
}
