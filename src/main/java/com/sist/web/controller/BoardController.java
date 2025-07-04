package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.dao.*;
import com.sist.web.entity.*;
import java.util.*;
@Controller
public class BoardController {

	 @Autowired
	 private BoardRepository bDao;
	 
	 @GetMapping("community/list")
	 public String board_list(@RequestParam(name="page",required = false) String page,Model model)
	 {
		 if(page==null)
			 page="1";
		 int curpage=Integer.parseInt(page);
		 int rowSize=10;
		 int start=(curpage*rowSize)-rowSize;
		 int end=rowSize*curpage;
		 List<BoardVO> list=bDao.boardListData(start,end);
		 
		 int count=(int)bDao.count();
		 int totalpage=(int)(Math.ceil(count/10.0));
		 
		 model.addAttribute("list", list);
		 model.addAttribute("curpage", curpage);
		 model.addAttribute("totalpage", totalpage);
		 model.addAttribute("main_html", "community/list");
		 return "main";
	 }
	 @GetMapping("community/insert")
	 public String board_insert(Model model)
	 {
		 
		 model.addAttribute("main_html", "community/insert");
		 return "main";
	 }
	 
	 @PostMapping("community/insert_ok")
	 public String board_insert_oK(BoardEntity vo)
	 {
		 bDao.save(vo);
		 return "redirect:/community/list";
	 }
	 
	 @GetMapping("community/detail")
	 public String board_detail(@RequestParam("no") int no,Model model)
	 {
		 BoardEntity vo=bDao.findByNo(no);
		 vo.setHit(vo.getHit()+1);
		 bDao.save(vo);
		 vo=bDao.findByNo(no);
		 model.addAttribute("vo", vo);
		 model.addAttribute("main_html", "community/detail");
		 return "main";
	 }
}