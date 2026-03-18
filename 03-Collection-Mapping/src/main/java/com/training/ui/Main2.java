package com.training.ui;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.bean.pack1.Question;
import com.training.util.HibernateUtil;

public class Main2 {

	static void insert(){
		Question question=new Question();
		question.setQuestionText("What is Java?");
		question.setMark(2);
		
		String[] choices={"It is a Programming Language", "It is a Scrpting Language"};
		question.setAnswerChoices(choices);
		
		
	}
	
	
	public static void main(String[] args) {
		insert();

	}

}
