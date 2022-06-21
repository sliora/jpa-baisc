package jpabasic.jpabook.jpashop.domain;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.mapping.FetchProfile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(fetch = LAZY)
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private List<Item> items = new ArrayList<>();

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
}
