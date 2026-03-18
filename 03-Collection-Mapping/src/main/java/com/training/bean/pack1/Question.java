package com.training.bean.pack1;

import java.util.Arrays;
import java.util.Objects;

public class Question {
	
	private int id;
	private String questionText;
	private int mark;
	private String[] answerChoices;
	
	public Question(int id, String questionText, int mark, String[] answerChoices) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.mark = mark;
		this.answerChoices = answerChoices;
	}
	public Question(String questionText, int mark, String[] answerChoices) {
		super();
		this.questionText = questionText;
		this.mark = mark;
		this.answerChoices = answerChoices;
	}
	public Question() {
		super();
	}
	
	
	public Question(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String[] getAnswerChoices() {
		return answerChoices;
	}
	public void setAnswerChoices(String[] answerChoices) {
		this.answerChoices = answerChoices;
	}
	@Override
	public String toString() {
		return "\n Question [id=" + id + ", questionText=" + questionText + ", mark=" + mark + ", answerChoices="
				+ "\n"+Arrays.toString(answerChoices) + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return id == other.id;
	}
	
	

}
