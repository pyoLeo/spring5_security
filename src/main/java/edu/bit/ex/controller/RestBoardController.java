package edu.bit.ex.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.page.PageVO;
import edu.bit.ex.service.BoardService;
import edu.bit.ex.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */

@RestController
@AllArgsConstructor
@Log4j
@RequestMapping("/restful/*") // ~restful로 들어오는 것들은 여기서 처리
public class RestBoardController {

	private BoardService boardService;

	// 1. list(처음 진입 화면이므로 화면이 깜박여도 상관없으므로 @Controller방식으로 접근 - veiw(화면)를 리턴
	@RequestMapping(value = "/", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView list(ModelAndView mav, Criteria cri) {
		mav.setViewName("list().......");
		mav.setViewName("rest/rest_list");
		mav.addObject("list", boardService.getListWithPaging(cri));
		int total = boardService.getTotalCount(cri);
		mav.addObject("pageMaker", new PageVO(cri, total));
		log.info("total : " + total);
		return mav;
	}

	@RequestMapping("/content/{bId}")
	public ModelAndView rest_content_view(BoardVO boardVO, ModelAndView mav) {
		log.info("content_view()......");
		mav.setViewName("rest/rest_content_view");
		mav.addObject("content_view", boardService.getContent(boardVO.getbId()));
		return mav;
	}

	@GetMapping("/write")
	public ModelAndView rest_write_view(ModelAndView mav) {
		log.info("write_view()......");
		mav.setViewName("rest/rest_write_view");
		return mav;
	}

	@PostMapping("/write")
	public ResponseEntity<String> write(@RequestBody BoardVO boardVO) {
		log.info("write()......");
		ResponseEntity<String> entity = null;
		
		try {
			boardService.write(boardVO);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}

	
	@PutMapping("/content/{bId}")
	public ResponseEntity<String> rest_update(@RequestBody BoardVO boardVO, ModelAndView modelAndView) {

		ResponseEntity<String> entity = null;

		log.info("rest_update..");
		try {

			// int rn = boardService.modify(boardVO);
			log.info("update 넘어온 숫자:::::");
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@DeleteMapping("/content/{bId}")
	public ResponseEntity<String> rest_delete(BoardVO boardVO, Model model) {
		ResponseEntity<String> entity = null;
		log.info("rest_delete..");
		try {
			boardService.delete(boardVO.getbId());
			// 삭제가 성공하면 성공 상태메시지 저장
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// 댓글 삭제가 실패하면 실패 상태메시지 저장
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		// 삭제 처리 HTTP 상태 메시지 리턴
		return entity;

	}

	// 댓글 페이지
	@GetMapping("/reply/{bId}")
	public ModelAndView rest_reply_view(ModelAndView mav, BoardVO boardVO) {
		mav.setViewName("rest/rest_reply_view");
		mav.addObject("reply_view", boardService.getContent(boardVO.getbId()));
		return mav;
	}

	// 댓글
	@PostMapping("/reply/{bId}")
	public ResponseEntity<String> rest_reply(@RequestBody BoardVO boardVO) throws Exception {
		ResponseEntity<String> entity = null;

		log.info("reply");

		try {
			boardService.writeReply(boardVO);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

}
