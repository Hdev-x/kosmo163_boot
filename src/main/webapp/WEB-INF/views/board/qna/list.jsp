<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/temp/head_css.jsp"></c:import>
</head>
<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">
		<c:import url="/WEB-INF/views/temp/sidebar.jsp"></c:import>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
				<c:import url="/WEB-INF/views/temp/topbar.jsp"></c:import>
				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->

					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800 font-weight-bold">
							<i class="fas fa-list-ul mr-2"></i>질문답변게시판
						</h1>
						<a href="./create"
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
							<i class="fas fa-plus fa-sm text-white-50 mr-1"></i> 글쓰기
						</a>
					</div>



					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">NOTICE LIST</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-hover" id="dataTable" width="100%"
									cellspacing="0">
									<thead class="thead-light">
										<tr class="text-center">
											<th style="width: 70px;">No</th>
											<th>제목</th>
											<th style="width: 100px;">작성자</th>
											<th style="width: 130px;">등록일</th>
											<th style="width: 80px;">조회수</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="d">
											<tr class="text-center">
												<td>${d.boardNo}</td>

												<td class="text-left pl-5"><a
													href="./detail?boardNo=${d.boardNo}"
													class="text-decoration-none font-weight-bold text-dark">
														<c:forEach begin="1" end="${d.boardDepth}">--
														</c:forEach> ${d.boardTitle}
												</a></td>

												<td>${d.boardWriter}</td>
												<td>${fn:substring(d.boardDate, 0, 10)}</td>
												<td>${d.boardViews}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>

					<div></div>

					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<li class="page-item ${pager2.pre?'':'disabled'}"><a
								class="page-link"
								href="./list?page=${pager2.pre?pager2.start-1:pager2.start}&kind=${pager2.kind}&search=${pager2.search}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
							<c:forEach begin="${pager2.start}" end="${pager2.end}" var="i">
								<li class="page-item"><a class="page-link"
									href="./list?page=${i}&kind=${pager2.kind}&search=${pager2.search}">${i}</a></li>
							</c:forEach>

							<li class="page-item ${pager2.next?'':'disabled'}"><a
								class="page-link"
								href="./list?page=${pager2.next?pager2.end+1:pager2.end}&kind=${pager2.kind}&search=${pager2.search}"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>

					<div
						class="row justify-content-center my-4 bg-transparent border-0">
						<div class="col-md-7 col-lg-6 bg-transparent border-0">
							<form action="./list" method="get"
								class="bg-transparent border-0">
								<div class="input-group shadow-sm" style="border-radius: 5px;">
									<div class="input-group-prepend">
										<select class="custom-select border-right-0" name="kind"
											style="border-radius: 5px 0 0 5px;">
											<option value="v1" ${pager2.kind == 'v1' ? 'selected' : ''}>제목</option>
											<option value="v2" ${pager2.kind == 'v2' ? 'selected' : ''}>작성자</option>
											<option value="v3" ${pager2.kind == 'v3' ? 'selected' : ''}>내용</option>
										</select>
									</div>

									<input type="text" value="${pager2.search}"
										class="form-control" placeholder="검색어를 입력하세요" name="search">

									<div class="input-group-append">
										<button class="btn btn-primary px-4" type="submit"
											style="border-radius: 0 5px 5px 0;">검색</button>
									</div>

								</div>
							</form>
						</div>
					</div>

				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->
			<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->
	<c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>
</body>
</html>