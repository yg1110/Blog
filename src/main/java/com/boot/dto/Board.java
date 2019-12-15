package com.boot.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Board")
public class Board {
	@Id
	private String title;
	private String date;
	private String category;
	private int comment;
	private String description;
	private String image;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public Board() {
		super();
	}
	@Override
	public String toString() {
		return "Board [title=" + title + ", date=" + date + ", category=" + category + ", comment=" + comment
				+ ", description=" + description + ", image=" + image + "]";
	}
	
}
