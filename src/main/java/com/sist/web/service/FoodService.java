package com.sist.web.service;
import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.dao.*;
import com.sist.web.vo.*;
import com.sist.web.entity.*;
// repository => 호출 
public interface FoodService {
	public List<FoodListVO> foodListData(int start,int end);
	public FoodEntity foodDetailData(int fno);
	public int foodTotalPage();
	
}