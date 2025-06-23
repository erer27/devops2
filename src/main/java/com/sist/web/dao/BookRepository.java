package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.BookEntity;
import com.sist.web.entity.FoodEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer>{
	
    @Query(value = "SELECT * FROM book ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 16 ROWS ONLY", nativeQuery = true)
    List<BookEntity> mainListData();
    
    @Query(value="SELECT id,title,auth,price,publisher,release_date,introduce,poster,num "
   		 +"FROM (SELECT id,title,auth,price,publisher,release_date,introduce,poster,rownum as num "
   		 +"FROM (SELECT id,title,auth,price,publisher,release_date,introduce,poster "
   		 +"FROM book ORDER BY id ASC)) "
   		 +"WHERE num BETWEEN :start AND :end",nativeQuery = true)
    List<BookEntity> bookListData(@Param("start") int start,@Param("end") int end);

    public BookEntity findById(int id); // where => where fno=? => select *
}
