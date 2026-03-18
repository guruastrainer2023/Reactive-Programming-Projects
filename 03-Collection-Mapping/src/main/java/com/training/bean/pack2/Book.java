package com.training.bean.pack2;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private int id;
	private String bookName;
	private String authorName;
	private List<String> topics;
	
	public Book(String bookName, String authorName) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.topics=new ArrayList<>();
	}

	public Book() {
		super();
		this.topics=new ArrayList<>();
	}
	
	
	
	public Book(int id) {
		super();
		this.id = id;
	}

	public void addTopic(String topic){
		this.topics.add(topic);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<String> getTopics() {
		return topics;
	}

	public void setTopics(List<String> topics) {
		this.topics = topics;
	}

	@Override
	public String toString() {
		return "\n Book [id=" + id + ", bookName=" + bookName + ", authorName=" + authorName + ", topics=" + topics + "]";
	}
	
	
	
	
}
