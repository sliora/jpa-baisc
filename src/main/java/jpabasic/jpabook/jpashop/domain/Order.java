package jpabasic.jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
@Data
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMEBER_ID")
    private Long memberId;          //이런식의 설계는 객체 설계를 테이블 설계에 맞춘 방식이다. 테이블의 외래키를 그대로 가져온다, 객체 그래프 탐색이 불가능하고 참조가 없으므로 UML도 잘못된다.즉 Member를 가져야한다.

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
