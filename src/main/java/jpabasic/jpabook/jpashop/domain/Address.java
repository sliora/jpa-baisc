package jpabasic.jpabook.jpashop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
public class Address {
    private String city;
    private String street;
    private String zipcode;

    public Address() {

    }
}
