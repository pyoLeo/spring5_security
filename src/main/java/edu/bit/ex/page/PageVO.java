package edu.bit.ex.page;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import edu.bit.ex.page.Criteria;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageVO {
    //페이징 처리 할때 필요한 정보들
     private int startPage; //화면에 보여지는 페이지 시작번호
     private int endPage;   //화면에 보여지는 끝번호
     private boolean prev, next; //이전페이지와 다음페이지 표시

     private int total;
     private Criteria cri;

     public PageVO(Criteria cri, int total) {

       this.cri = cri;
       this.total = total; //전체 글의 갯수

       this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;

       this.startPage = this.endPage - 9;
       
       //Total을 통한 endPage의 재계산
       int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

       if (realEnd <= this.endPage) {
         this.endPage = realEnd;
       }
       
       //시작번호가 1보다 큰경우
       this.prev = this.startPage > 1; 
       //realEnd가 endPage보다 큰 경우
       this.next = this.endPage < realEnd; 
     }
     
      public String makeQuery(int page) {
         UriComponents uriComponentsBuilder = UriComponentsBuilder.newInstance().queryParam("pageNum", page) // pageNum = 3
               .queryParam("amount", cri.getAmount()) // pageNum=3&amount=10
               .build(); // ?pageNum=3&amount=10
         return uriComponentsBuilder.toUriString(); // ?pageNum=3&amount=10 리턴 
      }

}