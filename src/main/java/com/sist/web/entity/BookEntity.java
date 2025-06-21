package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="book")
@Data
public class BookEntity {
	@Id
	int id;
	String title,auth,price,publisher,release_date,introduce,poster;
}
