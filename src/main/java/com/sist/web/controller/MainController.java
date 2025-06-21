package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import com.sist.web.entity.BookEntity;
import com.sist.web.service.BookService;

@Controller
public class MainController {
	@Autowired
	BookService bService;
	
	@GetMapping("/main")
	public String main_main(Model model)
	{

		List<BookEntity> list=bService.bookMainData();

		model.addAttribute("main_html", "main/home");
		model.addAttribute("list1", list.subList(0, 8));
		model.addAttribute("list2", list.subList(8, list.size()));
		return "main";
	}
	
	@GetMapping("/book/list")
	public String book_list(@RequestParam(name="page",required = false) String page,Model model)
	{

	   if(page==null)
		   page="1";
		
		   Map map=new HashMap();
		   int rowSize=12;
		   int curpage=Integer.parseInt(page);
		   int start=(rowSize*curpage)-(rowSize-1);
		   int end=rowSize*curpage;
		   List<BookEntity> list=bService.bookListData(start,end);
		   int totalpage=bService.bookTotalPage();
		   final int BLOCK=10;
		   int startPage=((Integer.parseInt(page)-1)/BLOCK*BLOCK)+1;
		   int endPage=((Integer.parseInt(page)-1)/BLOCK*BLOCK)+BLOCK;
		   if(endPage>totalpage)
			   endPage=totalpage;
		   
		   System.out.println(curpage+"sdfafasfsdfsdf");
		   
		   model.addAttribute("list", list);
		   model.addAttribute("curpage", curpage);
		   model.addAttribute("totalpage", totalpage);
		   model.addAttribute("startPage", startPage);
		   model.addAttribute("endPage", endPage);
		
		model.addAttribute("main_html", "book/list");
		return "main";
	}
}