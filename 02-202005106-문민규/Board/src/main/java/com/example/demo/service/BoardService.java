package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.BoardDTO;
import com.example.demo.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	//도서목록 조회
	public List<BoardDTO> getList() {
		// TODO Auto-generated method stub
		return boardRepository.getList();
	}
	
	//도서 추가(DB 저장)
	public void save(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		boardRepository.save(boardDTO);
	}
	
	//도서 상세정보 가져오기
	public BoardDTO detail(Integer id) {
		// TODO Auto-generated method stub
		return boardRepository.detail(id);
	}

	//도서정보 삭제하기
	public void goDelete(Integer id) {
		// TODO Auto-generated method stub
		boardRepository.goDelete(id);
		
	}
	
	//도서정보 수정.
	public void goUpdate(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		boardRepository.goUpdate(boardDTO);
		
	}
	
	//고객목록 조회
	public List<BoardDTO> customerList() {
		// TODO Auto-generated method stubs
		return boardRepository.customerList();
	}
	
	//고객 추가(DB 저장)
	public void pick(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		boardRepository.pick(boardDTO);
	}
	
	//고객 상세정보 가져오기
	public BoardDTO take(Integer id) {
		// TODO Auto-generated method stub
		return boardRepository.take(id);
	}
	
	//고객정보 삭제하기
	public void cuDelete(Integer id) {
		// TODO Auto-generated method stub
		boardRepository.cuDelete(id);
	}
	
	//고객정보 수정.
	public void cuUpdate(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		boardRepository.cuUpdate(boardDTO);
		
	}

}