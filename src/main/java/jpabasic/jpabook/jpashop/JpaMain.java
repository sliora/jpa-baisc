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

@SpringBootApplication
public class JpaMain {

    public static void main(String[] args) {
        SpringApplication.run(JpaMain.class, args);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /*Book book = new Book();
            book.setName("라틴어수업");
            book.setPrice(1000);
            book.setCreatedBy("kim");
            book.setCreatedDate(LocalDateTime.now());

            em.persist(book);

            em.flush();
            em.clear();
*/
            Book reference = em.getReference(Book.class,1L);
            System.out.println("reference.getClass() = " + reference.getClass());
            System.out.println("reference.getName() = " + reference.getName());

            em.detach(reference);

            System.out.println("reference.getName() = " + reference.getName());

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
