package br.com.fiap.fin_money_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Random;

@Entity
//@Table(name="tbl_categorias")
public class Category {
	@Id
	private Long id;
//	@Column(name = "nome")
	private String name;
//	@Column(name = "icone")
	private String icon;
	
	public Category(String name, String icon) {
		this.id = Math.abs(new Random().nextLong());
		this.name = name;
		this.icon = icon;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getIcon() {
		return icon;
	}

	@Override
	public String toString() {
		return "Category{" +
				"id=" + id +
				", name='" + name + '\'' +
				", icon='" + icon + '\'' +
				'}';
	}

	public void setId(Long id) {
		this.id = id;
	}
}
