package com.sist.web.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
@Service
public class FoodServiceImpl implements FoodService{
    // DAO 객체 주소 요청 
	@Autowired
	private FoodRepository fDao;

	@Override
	public List<FoodEntity> foodListData(int start,int end) {
		// TODO Auto-generated method stub
		return fDao.foodListData(start, end);
	}

	@Override
	public FoodEntity foodDetailData(int id) {
		// TODO Auto-generated method stub
		return fDao.findById(id);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		int count=(int)fDao.count();
		return (int)(Math.ceil(count/12.0));
	}
	
	
}