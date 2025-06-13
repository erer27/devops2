package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.FoodEntity;
import com.sist.web.vo.*;
import java.util.*;
@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Integer>{
   @Query(value="SELECT id,name,image,num "
		 +"FROM (SELECT id,name,image,rownum as num "
		 +"FROM (SELECT id,name,image "
		 +"FROM cocktail_cicd ORDER BY id ASC)) "
		 +"WHERE num BETWEEN :start AND :end",nativeQuery = true)
   public List<FoodEntity> foodListData(@Param("start") int start,@Param("end") int end);
   
   public FoodEntity findById(int id); // where => where fno=? => select *
}