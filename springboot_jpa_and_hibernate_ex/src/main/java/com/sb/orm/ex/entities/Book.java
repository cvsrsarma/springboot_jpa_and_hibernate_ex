package com.sb.orm.ex.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString@AllArgsConstructor
public class Book {
	
	long id;
	String name;
	String author;

}
