package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.BoardEntity;
import com.sist.web.entity.BoardVO;

import java.util.*;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
	@Query(value = "SELECT * FROM ( " +
            "  SELECT a.*, ROWNUM rnum FROM ( " +
            "    SELECT no, subject, name, regdate, hit FROM osj_board ORDER BY no DESC " +
            "  ) a WHERE ROWNUM <= :end " +
            ") WHERE rnum > :start",
    nativeQuery = true)
	public List<BoardVO> boardListData(@Param("start") int start, @Param("end") int end);
	
	public BoardEntity findByNo(@Param("no") Integer no);
	
	// 검색 
	public List<BoardEntity> findByNameContaining(@Param("name") String name);
	public List<BoardEntity> findBySubjectContaining(@Param("subject") String subject);
	public List<BoardEntity> findByContentContaining(@Param("content") String content);
}