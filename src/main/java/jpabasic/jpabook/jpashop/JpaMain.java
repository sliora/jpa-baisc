package jpabasic.jpabook.jpashop;

import jpabasic.jpabook.jpashop.domain.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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

            List<Member> resultList = em.createQuery(
                    "select m from Member m where m.name like '%kim%'",
                            Member.class).getResultList();
            for (Member member : resultList) {
                System.out.println("member = " + member);
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
