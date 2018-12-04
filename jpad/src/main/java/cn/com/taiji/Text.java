package cn.com.taiji;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.junit.Test;

import cn.com.taiji1.Customer;
import cn.com.taiji1.Order;
public class Text {
	@PersistenceContext
	EntityManager em;

	public static void main(String[] args) {
		// 1. ����EntityManagerFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpad");

		// 2. ����EntityManager
		EntityManager entityManager = factory.createEntityManager();

		// 3.��������
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		// 4. �־û�����
		User user = new User();
		
		user.setUsername("dou");
		user.setPassword("123456");

		// ���user�����ݿ⣬�൱��hibernate��save();
		entityManager.persist(user);

		// 5. �ύ����
		transaction.commit();

		// 6. �ر�EntityManager
		entityManager.close();

		// 7. �ر�EntityManagerFactory
		factory.close();
	}
	@Test
	public void manytoone() {
		// 1. ����EntityManagerFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpad");

		// 2. ����EntityManager
		EntityManager entityManager = factory.createEntityManager();

		// 3.��������
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Customer customer =new Customer();
		customer.setAge(18);
		customer.setBirth(new Date());
		customer.setCreatedTime(new Date());
		customer.setEmail("411678730@qqcom");
		customer.setLastName("FF");
		
		Order order1=new Order();
		order1.setOrderName("1-FF-1");
		Order order2=new Order();
		order2.setOrderName("2-FF-2");
		entityManager.persist(customer);
		entityManager.persist(order1);
		entityManager.persist(order2);
		transaction.commit();

		// 6. �ر�EntityManager
		entityManager.close();

		// 7. �ر�EntityManagerFactory
		factory.close();
		
	}

 

}

