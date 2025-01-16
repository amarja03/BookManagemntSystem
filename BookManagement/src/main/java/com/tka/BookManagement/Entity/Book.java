package com.tka.BookManagement.Entity;

public class Book {
int id;
String name;
String Author;
double price;
public Book(int id, String name, String Author, double price) {
	super();
	this.id = id;
	this.name = name;
	this.Author = Author;
	this.price = price;
}
@Override
public String toString() {
	return "Book [id=" + id + ", name=" + name + ", Author=" + Author + ", price=" + price + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAuthor() {
	return Author;
}
public void setAuthor(String Author) {
	this.Author = Author;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
}
