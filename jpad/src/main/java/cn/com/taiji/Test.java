package cn.com.taiji;

import cn.com.taiji1.Customer;
import cn.com.taiji1.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpad");
         EntityManager entityManager = entityManagerFactory.createEntityManager();
         EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

      // add(entityManager);
        //find(entityManager);
        //del(entityManager);
        update(entityManager);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
    /*public static void add(EntityManager entityManager){
        Customer customer = new Customer();
        customer.setName("lisi");
        customer.setAge(24);

        Order order1 = new Order();
        order1.setName("CC");
        order1.setCustomer(customer);
        Order order2 = new Order();
        order2.setName("DD");
        order2.setCustomer(customer);

        entityManager.persist(customer);
        entityManager.persist(order1);
        entityManager.persist(order2);
    }

    public static  void find(EntityManager entityManager){
        Order order = entityManager.find(Order.class,1);
         Customer customer = order.getCustomer();
        System.out.println(order.getName());
        System.out.println(customer.getName());
    }

    public static void del(EntityManager entityManager){
        Order order =entityManager.find(Order.class,1);
        entityManager.remove(order);
    }

    public static void update(EntityManager entityManager){
        Order order =entityManager.find(Order.class,2);
        order.getCustomer().setAge(99);
    }*/





    public static void add(EntityManager entityManager){
        Customer customer = new Customer();
        customer.setLastName("wangwu");
        customer.setAge(25);

        Order order1 = new Order();
        order1.setOrderName("EE");

        Order order2 = new Order();
        order2.setOrderName("FF");
        Set set = new HashSet();
        set.add(order1);
        set.add(order2);
        customer.setOrders(set);

        entityManager.persist(order1);
        entityManager.persist(order2);
        entityManager.persist(customer);
    }
    public static void find(EntityManager entityManager){
         Customer customer = entityManager.find(Customer.class, 3);
        System.out.println(customer.getLastName());
        System.out.println(customer.getOrders().size());
    }
    public static void del(EntityManager entityManager){
         Customer customer = entityManager.find(Customer.class, 3);
        entityManager.remove(customer);
    }
    public static void update(EntityManager entityManager){
        Customer customer = entityManager.find(Customer.class, 3);
        customer.getOrders().iterator().next().setOrderName("GG");
    }
}

