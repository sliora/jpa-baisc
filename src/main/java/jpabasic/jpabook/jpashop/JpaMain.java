package jpabasic.jpabook.jpashop;

import jpabasic.jpabook.jpashop.domain.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class JpaMain {

    public static void main(String[] args) {
        SpringApplication.run(JpaMain.class, args);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Book book = new Book();
            book.setName("로마법수업");
            book.setPrice(1000);

            em.persist(book);

            em.flush();
            em.clear();


            Book book1 = em.find(Book.class, book.getId());

            System.out.println("book1 = " + book1);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
