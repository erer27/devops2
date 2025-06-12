package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
// spring-boot : JSP지원하지 않는다 => maven  => 배포 war (풀어서) => bat => JSP가 사라지고 있다 
// thymeleaf : HTML => gradle => jar 
// back-end : spring-boot / django / nodejs 
//                          | python / numpy / pandas => AI 
// ==> DataBase : Oracle / MySQL / Mariadb ==> JPA , MyBatis 

/*
 *  FNO           NUMBER(38)     
	NAME          VARCHAR2(4000) 
	TYPE          VARCHAR2(4000) 
	PHONE         VARCHAR2(26)   
	ADDRESS       VARCHAR2(4000) 
	SCORE         NUMBER(38,1)   
	THEME         VARCHAR2(4000) 
	POSTER        VARCHAR2(4000) 
	IMAGES        VARCHAR2(4000) 
	TIME          VARCHAR2(128)  
	PARKING       VARCHAR2(4000) 
	CONTENT       VARCHAR2(4000) 
	PRICE         VARCHAR2(26)   
	
 */
@Entity(name="project_food")
@Data
public class FoodEntity {
   @Id
   private int fno;
   private String name,type,phone,address,theme,images,time,parking,content,price,poster;
   private double score;
}