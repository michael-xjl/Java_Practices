package com.hedleyproctor.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Category4 {
	private Long id;
	private String name;
	private Set<Item4> items = new HashSet<Item4>();
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
    @OneToMany(orphanRemoval=true)
//    @JoinColumn(name="CUST_ID") // join column is in table for Order
	public Set<Item4> getItems() {
		return items;
	}
	public void setItems(Set<Item4> items) {
		this.items = items;
	}

	
	
}
