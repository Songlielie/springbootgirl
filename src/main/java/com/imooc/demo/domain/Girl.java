package com.imooc.demo.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.validation.constraints.Min;

@Entity
public class Girl {
	@Id
	@GeneratedValue
	private Integer Id;
	@NotEmpty(message = "用户名不能为空！")
	private String name;
	@Min(value = 18,message = "未成年少女禁止入内！")
	private Integer age;
	private String money;

	public Girl() {
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}


	@Override
	public String toString() {
		return "Girl{" + "Id=" + Id + ", name='" + name + '\'' + ", age=" + age + ", money='" + money + '\'' + '}';
	}
}
