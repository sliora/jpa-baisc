package jpabasic.hellojpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@SpringBootApplication
public class HelloJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloJpaApplication.class, args);


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		try {

			List<Member> result = em.createQuery("select m from Member as m", Member.class)
					.setFirstResult(5)
					.setMaxResults(8)
					.getResultList();

			for (Member member : result) {
				System.out.println("member = " + member.getName());
			}

			//find, update
			/*Member findMember = em.find(Member.class, 1L);
			System.out.println("findMember.getId() = " + findMember.getId());
			System.out.println("findMember.getName() = " + findMember.getName());

			findMember.setName("HelloJPA");*/

			//insert
/*			Member member = new Member();
			member.setId(2L);
			member.setName("HelloB");
			em.persist(member);*/

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			em.close();
		}

		emf.close();

	}

}
