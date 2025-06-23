package com.sist.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.web.dao.BookRepository;
import com.sist.web.entity.BookEntity;

@Repository
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bDao;

	@Override
	public List<BookEntity> bookMainData() {
		
		return bDao.mainListData();
	}

	@Override
	public List<BookEntity> bookListData(int start, int end) {
		// TODO Auto-generated method stub
		return bDao.bookListData(start,end);
	}

	@Override
	public int bookTotalPage() {
		// TODO Auto-generated method stub
		int count=(int)bDao.count();
		return (int)(Math.ceil(count/12.0));
	}

	@Override
	public BookEntity bookDetailData(int id) {
		// TODO Auto-generated method stub
		return bDao.findById(id);
	}

}
