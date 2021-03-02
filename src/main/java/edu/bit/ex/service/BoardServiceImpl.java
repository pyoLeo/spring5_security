package edu.bit.ex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.ex.controller.RestBoardController;
import edu.bit.ex.mapper.BoardMapper;
import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList()......");
		return mapper.getList();
	}

	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) {
		// TODO Auto-generated method stub
		log.info("getListWithPaging()......");
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		log.info("getTotal()......");
		return mapper.getTotalCount(cri);
	}

	@Override
	public void write(BoardVO boardVO) {
		// TODO Auto-generated method stub
		log.info("writeBoard()......");
		mapper.write(boardVO);
	}

	@Override
	public void writeReply(BoardVO boardVO) {
		// TODO Auto-generated method stub
		log.info("writeReply()......");
		mapper.replyShape(boardVO);
		mapper.reply(boardVO);
	}

	@Override
	public BoardVO getContent(int bId) {
		// TODO Auto-generated method stub
		log.info("getContent()......");
		mapper.upHit(bId);
		return mapper.getContent(bId);
	}

	@Override
	public void delete(int bId) {
		// TODO Auto-generated method stub
		log.info("delete()......");
		mapper.delete(bId);
	}

	@Override
	public void modify(BoardVO boardVO) {
		// TODO Auto-generated method stub
		log.info("modify()......");
		mapper.modify(boardVO);
	}
	

}
