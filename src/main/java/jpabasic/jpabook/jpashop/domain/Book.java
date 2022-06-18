package jpabasic.jpabook.jpashop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book extends Item{

    private String author;

    private String isbn;

}
