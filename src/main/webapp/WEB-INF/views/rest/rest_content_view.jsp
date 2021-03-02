<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function(){
	    
		//https://m.blog.naver.com/PostView.nhn?blogId=moonv11&logNo=220605582547&proxyReferer=https:%2F%2Fwww.google.com%2F
		$("#updateForm").submit(function(event){
			
			event.preventDefault();
			
	        var name = $("#bName").val();
	        var bTitle = $("#bTitle").val();
	        var bContent = $("#bContent").val();	        
	        var bId = $("#bId").val();
	        console.log(bContent);
	        console.log($(this).attr("action"));
	        
	        var form = {
	        		bId: bId,
	        		bName: name,
	                bContent: bContent,
	                bTitle: bTitle
	        };
		    //dataType: 'json',
	        $.ajax({
			    type : "PUT",
			    url : $(this).attr("action"),
			    cache : false,
			    contentType:'application/json; charset=utf-8',
 			    data: JSON.stringify(form), 
			    success: function (result) {       
					if(result == "SUCCESS"){
						//list로 
						$(location).attr('href', '${pageContext.request.contextPath}/restful/')				      	       
					}					        
			    },
			    error: function (e) {
			        console.log(e);
			    }
			})	       
	
	    }); // end submit()
	    
	}); // end ready()
</script>
<script type="text/javascript">
	$(document).ready(function (){
		$('#delete').click(function(event){
			event.preventDefault();
			console.log("ajax 호출전");		
			//var trObj = $(this).parent().parent(); 
 
			$.ajax({
				type : 'DELETE',
				url : $(this).attr("href"),
				cache : false,
				success: function(result){
					console.log(result);
					if(result=="SUCCESS"){
						if(result == "SUCCESS"){     
                  					$(location).attr('href', '${pageContext.request.contextPath}/restful/')                            
               				}  
					}
				},
				error:function(e){
					console.log(e);
				}
			})
		});	
	});	
	</script>
</head>
<body>
	<table id="list-table" width="500" cellpadding="0" cellspacing="0" border="1">
		<form id="updateForm" action="${pageContext.request.contextPath}/restful/content/${content_view.bId}" method="post">
			<input type="hidden" id="bId" value="${content_view.bId}">
			<tr>
				<td> 번호 </td>
				<td> ${content_view.bId} </td>
			</tr>
			<tr>
				<td> 히트 </td>
				<td> ${content_view.bHit} </td>
			</tr>
			<tr>
				<td> 이름 </td>
				<td> <input type="text" id="bName" value="${content_view.bName}"></td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" id="bTitle" value="${content_view.bTitle}"></td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <textarea rows="10" id="bContent" name="content" >${content_view.bContent}</textarea></td>
			</tr>
			<tr >
				<td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; <a href="${pageContext.request.contextPath}/restful/">목록보기</a> &nbsp;&nbsp; <a id="delete">삭제</a> &nbsp;&nbsp; <a href="${pageContext.request.contextPath}/restful/reply/${content_view.bId}">답변</a></td>
			</tr>
		</form>
	</table>
	
</body>
</html>