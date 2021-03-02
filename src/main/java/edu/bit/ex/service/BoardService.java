package edu.bit.ex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.BoardMapper;
import edu.bit.ex.page.Criteria;
import edu.bit.ex.service.BoardServiceImpl;
import edu.bit.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


public interface BoardService {

	public List<BoardVO> getList();	//게시글 목록 불러오기

	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
	public void write(BoardVO boardVO);

	public void writeReply(BoardVO boardVO);

	public BoardVO getContent(int bno);

	public void delete(int bId);
	
	public void modify(BoardVO boardVO);
	
}
