package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor

public class BoardRepository {
	
	private final SqlSessionTemplate sql;
	
	//도서목록 조회
	public List<BoardDTO> getList() {
		// TODO Auto-generated method stub
		return sql.selectList("Board.getList");
	}
	
	//도서 추가(DB 저장)
	public void save(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		sql.insert("Board.save", boardDTO);
	}

	//도서 상세정보 가져오기
	public BoardDTO detail(Integer id) {
		// TODO Auto-generated method stub
		return sql.selectOne("Board.detail", id);
	}

	//도서정보 삭제하기
	public void goDelete(Integer id) {
		// TODO Auto-generated method stub
		sql.delete("Board.goDelete", id);
		
	}
	
	//도서정보 수정.
	public void goUpdate(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		sql.update("Board.goUpdate", boardDTO);
		
	}
	//고객목록 조회
	public List<BoardDTO> customerList() {
		// TODO Auto-generated method stub
		return sql.selectList("Board.customerList");
	}
	
	//고객 추가(DB 저장)
	public void pick(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		sql.insert("Board.pick", boardDTO);
	}
	
	//고객 상세정보 가져오기
	public BoardDTO take(Integer id) {
		// TODO Auto-generated method stub
		return sql.selectOne("Board.take", id);
	}
	
	//고객정보 삭제하기
	public void cuDelete(Integer id) {
		// TODO Auto-generated method stub
		sql.delete("Board.cuDelete", id);
		
	}
	
	//고객정보 수정.
	public void cuUpdate(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		sql.update("Board.cuUpdate", boardDTO);
		
	}
};