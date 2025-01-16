package com.tka.BookManagement.Entity;

public class Library {
	private int lid;
	private String name;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Library [lid=" + lid + ", name=" + name + "]";
	}
	public Library() {
		super();
	}
	public Library(int lid, String name) {
		super();
		this.lid = lid;
		this.name = name;
	}

}
