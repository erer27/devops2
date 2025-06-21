package com.sist.web.service;

import java.util.*;

import com.sist.web.entity.BookEntity;

public interface BookService {
	
	List<BookEntity> bookMainData();
	List<BookEntity> bookListData(int start, int end);
	int bookTotalPage();
}
