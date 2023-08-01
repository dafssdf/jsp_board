<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>글 보기</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/boardRead.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="view-wrap">
			<div class="view-title">
				<h1>
					<!--BoardReadOk에서 가져온 board라는 값을 가져서 get을 이용하면 값을 가져올수있다.  -->
					<c:out value="${board.getBoardTitle()}" />
				</h1>
			</div>
			<div class="view-info">
				<div class="info-title">
					<div class="title-wrap">
						<span class="writer">작성자</span>
						<!-- 임시 작성자 -->
						<div class="content-writer">
							<c:out value="${board.getMemberId() }" />
						</div>
					</div>
					<div class="title-wrap">
						<span class="date">작성일</span>
						<!-- 임시 작성일 -->
						<div class="content-date">
							<c:out value="${board.getBoardDate() }" />
						</div>
					</div>
					<div class="title-wrap">
						<span class="hit">조회수</span>
						<!-- 임시 조회수 -->
						<div class="content-hit">
							<c:out value="${board.getBoardReadCount() }" />
						</div>
					</div>
				</div>
			</div>
			<!-- 임시 내용 -->
			<div class="view-content">
				<c:out value="${board.getBoardContent() }" />
			</div>
			<!-- 임시 첨부 파일 -->
			<div class="view-attach">
				<c:forEach var="file" items="${board.getFiles()}">
					<div class="img-box">
						<img
							src="${pageContext.request.contextPath}/upload/${file.getFileSystemName()}">

						<a
							href="${pageContext.request.contextPath}/file/download.file?fileSystemName=${file.getFileSystemName()}&fileOriginName=${file.getFileOriginName()}">
							<div class="download-btn">
								<svg viewBox="0 0 14 14" xmlns="http://www.w3.org/2000/svg">
                           <path fill-rule="evenodd" clip-rule="evenodd"
										d="M6.44325 7.02619L3.36676 4.05286C3.13236 3.93626 2.83937 3.96541 2.63427 4.05286C2.42917 4.28606 2.42917 4.60672 2.63427 4.81077L6.61905 8.6586C6.82415 8.86265 7.14644 8.86265 7.35154 8.6586L11.3656 4.78162C11.5707 4.57757 11.5707 4.25691 11.3656 4.05286C11.1605 3.84881 10.8089 3.84881 10.6038 4.05286L7.49804 7.02619L7.49804 1.1084C7.49804 0.816895 7.26364 0.583984 6.97064 0.583984C6.67765 0.583984 6.44325 0.816895 6.44325 1.1084L6.44325 7.02619ZM1.63829 9.91137C1.63829 9.61987 1.40389 9.38638 1.11089 9.38638C0.817895 9.38638 0.583496 9.64873 0.583496 9.94023V12.8923C0.583496 13.1838 0.817895 13.4167 1.11089 13.4167H12.8894C13.1824 13.4167 13.4168 13.1838 13.4168 12.8923V9.94023C13.4168 9.64873 13.1824 9.41582 12.8894 9.41582C12.5964 9.41582 12.362 9.64873 12.362 9.94023V12.3381H1.63829V9.91137Z"></path></svg>
							</div>
						</a>
					</div>
				</c:forEach>

			</div>
			<div class="btn-group">
				<!-- 각 버튼 처리 경로 js로 수정하기 -->
				<!--Read.js파일의 boardNumber를 넘겨주기 위한  -->
				<button type="button" class="list-btn"
					data-boardnumber="${board.getBoardNumber()}">목록</button>
				<!--로그인 하고 자신의 글을 삭제 해야 하기 때문에 수정 삭제를 나오게 하고 아니면 목록만 보이게 처리  -->
				<c:if
					test="${sessionScope.memberNumber == board.getMemberNumber() }">
					<button type="button" class="modify-btn">수정</button>
					<button type="button" class="delete-btn">삭제</button>
				</c:if>

			</div>

			<!-- 댓글 수정중 -->
			<div class="comment-form">
				<form id="comment-form">
					<input type="hidden" name="boardNumber"
						value="${board.getBoardNumber()}">
					<div class="form-group">
						<textarea name="content" id="content" placeholder="댓글 내용을 입력하세요."></textarea>
					</div>
					<button type="button" class="submit-btn">댓글 작성</button>
				</form>
			</div>

			<div class="comment-list">
				<!-- 리스트 예시 -->
				<ul id="comment-list">
					<li>
						<div class="comment-info">
							<span class="writer">홍길동</span> <span class="date">2222-22-22</span>
						</div>
						<div class="comment-content-wrap">
							<div class="comment-content">
								<p>안녕하세요</p>
							</div>
							<div class="comment-btn-group">
								<button type=button class="comment-modify-ready">수정</button>
								<button type=button class="comment-delete">삭제</button>
							</div>
							<div class="comment-btn-group none">
								<button type=button class="comment-modify">수정 완료</button>
							</div>
						</div>
					</li>
				</ul>
				<!-- /리스트 예시 -->
			</div>

			<!-- 댓글 수정중 -->

		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<!--js파일에서는 EL문을 사용할수 없지만 jsp 파일에서 사용이 가능하다 이러면 세션에 있는 회원 번호를 사용가능 하다. js 파일 연결 위에 해줘야 먼저 인식해서 사용가능한것  -->
	<script >
		let memberNumber = "${sessionScope.memberNumber}";
	</script>
	<script
		src="${pagetContext.request.contextPath}/assets/js/boardRead.js"></script>

</body>
</html>

