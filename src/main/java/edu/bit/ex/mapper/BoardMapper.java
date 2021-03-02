package edu.bit.ex.mapper;

import java.util.List;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;

public interface BoardMapper {

	public List<BoardVO> getList();

	public void write(BoardVO boardVO);

	public BoardVO getContent(int bno);

	public void updateShape(BoardVO boardVO);

	public void reply(BoardVO boardVO);
	
	public void replyShape(BoardVO boardVO);

	public int delete(int bId);

	public List<BoardVO> getListWithPaging(Criteria cri);

	public int getTotalCount(Criteria cri);

	public void upHit(int bno);

	public void modify(BoardVO boardVO);

}
