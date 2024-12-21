package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	//도서목록 조회
	@GetMapping("/list")
	public String getList(Model model) {
		
		List<BoardDTO> boardDTO = boardService.getList();
		model.addAttribute("bookList", boardDTO);
		return "bookList";
	}
	
	//도서 추가 화면 호출
	@GetMapping("/addBook")
	public String addBook() {
		System.out.println("도서 추가 화면 컨트롤러");
		return "addBook";
	}
	
	//도서 추가 (DB저장)
	@PostMapping("/addBook")
	public void save(BoardDTO boardDTO) {
		boardService.save(boardDTO);
		
	}
	
	//도서 상세정보 가져오기.
	@GetMapping("/{id}")
	public String detail(@PathVariable("id") Integer id, Model model) {
		BoardDTO boardDTO = boardService.detail(id);
		model.addAttribute("bookDetail", boardDTO);
		return "detailBook";
	}
	
	//도서정보 삭제하기.
	@GetMapping("/goDelete/{id}")
	public String goDelete(@PathVariable("id") Integer id) {
		boardService.goDelete(id);
		return "redirect:/list";
	}
	
	//도서정보 수정화면 호출.
	@GetMapping("/goUpdate/{id}")
	public String goUpdate(@PathVariable("id") Integer id, Model model) {
		BoardDTO boardDTO = boardService.detail(id);
		model.addAttribute("bookDetail", boardDTO);
		return "updateBook";
	}
	
	//도서정보 수정.
	@PostMapping("/goUpdate/{id}")
	public String goUpdate(BoardDTO boardDTO, Model model) {
		boardService.goUpdate(boardDTO); //update 작업 요청.
		
		//update 완료 후, 수정된 내용을 다시 조회
		BoardDTO dto = boardService.detail(boardDTO.getBookid());
		model.addAttribute("bookDetail", dto);
		return "detailBook";
	}
	
	//고객목록 조회
	@GetMapping("/customerlist")
	public String customerList(Model model) {
		
		List<BoardDTO> boardDTO = boardService.customerList();
		model.addAttribute("customerList", boardDTO);
		return "customerList";
	}
	
	//고객 추가 화면 호출
	@GetMapping("/addCustomer")
	public String addCustomer() {
		System.out.println("고객 추가 화면 컨트롤러");
		return "addCustomer";
	}
	
	//고객 추가 (DB저장)
	@PostMapping("/addCustomer")
	public void pick(BoardDTO boardDTO) {
		boardService.pick(boardDTO);
		
	}
	
	//고객 상세정보 가져오기.
	@GetMapping("/customer/{cuid}")
	public String take(@PathVariable("cuid") Integer id, Model model) {
		BoardDTO boardDTO = boardService.take(id);
		model.addAttribute("customerDetail", boardDTO);
		return "customerDetail";
	}
	
	//고객정보 삭제하기.
	@GetMapping("/cuDelete/{cuid}")
	public String cuDelete(@PathVariable("cuid") Integer id) {
		boardService.cuDelete(id);
		return "redirect:/customerlist";
	}
	
	//고객정보 수정화면 호출.
	@GetMapping("/cuUpdate/{cuid}")
	public String cuUpdate(@PathVariable("cuid") Integer id, Model model) {
		BoardDTO boardDTO = boardService.take(id);
		model.addAttribute("customerDetail", boardDTO);
		return "updateCustomer";
	}
	
	//고객정보 수정.
	@PostMapping("/cuUpdate/{cuid}")
	public String cuUpdate(BoardDTO boardDTO, Model model) {
		boardService.cuUpdate(boardDTO); //update 작업 요청.
		
		//update 완료 후, 수정된 내용을 다시 조회
		BoardDTO dto = boardService.take(boardDTO.getCustid());
		model.addAttribute("customerDetail", dto);
		return "customerDetail";
	}
	
	
			
}

