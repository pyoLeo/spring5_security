<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
   <title>유저 페이지</title>
</head>

<body>

<h1>유저 페이지 입니다.</h1>

<p>principal: <sec:authentication property="principal"/></p>
<p>MemberVO: <sec:authentication property="principal.member"/></p>
<p>사용자이름: <sec:authentication property="principal.member.username"/></p>
<p>사용자비밀번호: <sec:authentication property="principal.member.password"/></p>
<p>사용자정보: <sec:authentication property="principal.member.authList"/></p>
<%-- <p>EmpVO: <sec:authentication property="principal.emp"/></p>
<p>사용자이름: <sec:authentication property="principal.emp.ename"/></p>
<p>사용자월급: <sec:authentication property="principal.emp.sal"/></p>
<p>사용자입사일자: <sec:authentication property="principal.emp.hiredate"/></p> --%>
<p><a href="<c:url value="/" />">홈</a></p>

<%-- <sec:authorize access="isAnnonymous()">
	로그인
	회원가입
</sec:authorize>

<sec:authorize access="isAuthentacated()">
	로그아웃
	회원정보
</sec:authorize>

<sec:authorize access="hasRole('admin')">
	관리자 페이지
</sec:authorize> --%>

</body>
</html>