package com.ljheee.orm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test {

	public static void main(String[] args) {

		//标准服务注册（加载Hibernate配置文件）
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		//获得会话工厂
		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
//		Category category = new Category("电子", "手表");
//		Category c2 = new Category("数码", "手机");
//		Category c3 = new Category("儿童", "玩具");
//		
//		session.save(category);
//		session.save(c2);
//		session.save(c3);
//		
//		session.save(new Product("MX4", 1209, c2));
//		session.save(new Product("Kaxio", 178, category));
//		session.save(new Product("AoTomam", 59, c3));

		List<Category> list = session.createQuery("from Category").list();
		
//		for (Category category : list) {//单向
//			System.out.println(category);
//		}
		
		Category c1 = list.get(0);
		System.out.println(c1.getTitle());
		
		for (Product p : c1.getProducts()) {//查询  该类别下所有产品
			System.out.println(p);
		}
		
		c1.addProduct(new Product("AppleWatch", 2209, c1));//更新类别，会级联更新产品
		session.saveOrUpdate(c1);
		
		for (Product p : c1.getProducts()) {//查询  该类别下所有产品
			System.out.println(p);
		}
		session.getTransaction().commit();
		session.close();
		factory.close();//会话工厂一般不自己关闭--程序结束。
	}

}
