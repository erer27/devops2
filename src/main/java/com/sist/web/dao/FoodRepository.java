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
   @Query(value="SELECT fno,name,poster,num "
		 +"FROM (SELECT fno,name,poster,rownum as num "
		 +"FROM (SELECT fno,name,poster "
		 +"FROM project_food ORDER BY fno ASC)) "
		 +"WHERE num BETWEEN :start AND :end",nativeQuery = true)
   public List<FoodListVO> foodListData(@Param("start") int start,@Param("end") int end);
   
   public FoodEntity findByFno(int fno); // where => where fno=? => select *
}