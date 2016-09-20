package com.ljheee.orm;

import java.util.HashSet;
import java.util.Set;
/**
 * [产品]类别
 * @author ljheee
 *
 */
public class Category {

	private Long id;
	private String title;//类别名
	private String desc;//类别描述

	//不加此行是单向连接，由产品可知是属于哪个类别。
	/**
	 * 产品集合
	 * 即该类别下，所属的所有产品
	 */
	private Set<Product> products = new HashSet<>();//集合没有序号
	

	public void addProduct(Product p){
		products.add(p);
	}
	 
	 
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Category() {
	}
	//对象状态
	//1	瞬时状态
	//2	持久化状态
	//3	托管状态
	public Category(String title, String desc) {
		super();
		this.title = title;
		this.desc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", title=" + title + ", desc=" + desc + "]";
	}
	
	
	

}
