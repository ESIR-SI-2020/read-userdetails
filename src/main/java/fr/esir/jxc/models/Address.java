package fr.esir.jxc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String postalCode;
    private String street;
    private Integer streetNumber;
    private String complement;
}
