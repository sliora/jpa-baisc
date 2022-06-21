package jpabasic.jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@Table(name = "ORDER_ITEM")
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private int orderPrice;
    private int count;
}
