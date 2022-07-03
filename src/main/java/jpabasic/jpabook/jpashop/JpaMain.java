package jpabasic.jpabook.jpashop;

import jpabasic.jpabook.jpashop.domain.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class JpaMain {

    public static void main(String[] args) {
        SpringApplication.run(JpaMain.class, args);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setName("member");
            member.setAddress(new Address("city", "street", "10000"));
            em.persist(member);

            Order order = new Order();
            order.setMember(member);
            order.setStatus(OrderStatus.ORDER);
            em.persist(order);

            em.flush();
            em.clear();

            String query = "select m.status, 'HELLO', true from Order m where m.status = :orderStatus";


            List<Object[]> resultList = em.createQuery(query)
                    .setParameter("orderStatus", OrderStatus.ORDER)
                    .getResultList();

            System.out.println("resultList.size() = " + resultList.size());
            for (Object[] objects : resultList) {
                System.out.println("objects[0] = " + objects[0]);
                System.out.println("objects[0] = " + objects[1]);
                System.out.println("objects[0] = " + objects[2]);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.out.println("e = " + e);
        } finally {
            em.close();
        }

        emf.close();

    }
}
