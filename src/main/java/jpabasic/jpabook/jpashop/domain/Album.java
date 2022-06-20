package jpabasic.jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Album extends Item{

    private String Artist;

}
