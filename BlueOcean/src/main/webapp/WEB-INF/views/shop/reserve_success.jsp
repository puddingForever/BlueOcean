<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<c:import url="/WEB-INF/views/include/header.jsp" />
<script>
alert("옵션 선택이 완료되었습니다.");
location.href="${root}shop/rocketReserveInfo?rocket_idx="+${rocket_idx};
</script>






<c:import url="/WEB-INF/views/include/footer.jsp" />

