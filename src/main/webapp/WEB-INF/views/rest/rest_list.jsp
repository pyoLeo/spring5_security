<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function (){
		$('.a-delete').click(function(event){
			//prevendDefault()는 href로 연결해 주지 않고 단순히 click에 대한 처리를 하도록 해준다.
			event.preventDefault();
			console.log("ajax 호출전"); 
			//해당 tr제거
			var trObj =  $(this).parent().parent();
			
			$.ajax({
			    type : "DELETE",
			    url : $(this).attr("href"),
/* 			    data:{"bId":"${content_view.bId}"}, */
			    success: function (result) {       
			        console.log(result); 
					if(result == "SUCCESS"){
			           //getList();
				      $(trObj).remove();  
				      	       
					}					        
			    },
			    error: function (e) {
			        console.log(e);
			    }
			})
			 
		});
	});	
</script>
<body>
	
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.bId}</td>
			<td>${dto.bName}</td>
			<td>
				<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
				<a href="${pageContext.request.contextPath}/restful/content/${dto.bId}">${dto.bTitle}</a></td>
			<td>${dto.bDate}</td>
			<td>${dto.bHit}</td>
			<td><a class="a-delete" data-bid='${dto.bId}' href="${pageContext.request.contextPath}/restful/${dto.bId}">삭제</a></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"> <a href="${pageContext.request.contextPath}/restful/write">글작성</a> </td>
		</tr>
	</table>
	<c:if test="${pageMaker.prev}">
       					  <a href="${pageMaker.makeQuery(pageMaker.startPage - 1) }">«</a>
     					 </c:if>

     					 <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
        				 <c:out value="${pageMaker.cri.pageNum == idx?'':''}" />
        					 <a href="${pageMaker.makeQuery(idx)}">${idx}</a>
   					   </c:forEach>
      
    				  <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
    				     <a href="${pageMaker.makeQuery(pageMaker.endPage +1) }"> » </a>
  				    </c:if> <br>
</body>
</html>