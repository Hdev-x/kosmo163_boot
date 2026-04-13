<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
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
							<i class="fas fa-list-ul mr-2"></i>교수 목록
						</h1>
						<a href="./create"
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
							<i class="fas fa-plus fa-sm text-white-50 mr-1"></i> 새 교수 등록
						</a>
					</div>



					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">PROFESSOR List</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-hover" id="dataTable" width="100%"
									cellspacing="0">
									<thead class="thead-light">
										<tr>
											<th>No</th>
											<th>교수명</th>
											<th>학과번호</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="d">
											<tr>
												<td>${d.professorNo}</td>
												<td><a href="./detail?professorNo=${d.professorNo}"
													class="text-decoration-none font-weight-bold">
														${d.noticeTitle} </a></td>
												<td>${d.professorNo}</td>
												<td>${d.noticeDate}</td>
												<td>${d.noticeViews}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>


					<div></div>

					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item ${pager2.pre?'':'disabled'}"><a
								class="page-link"
								href="./list?page=${pager2.pre?pager2.start-1:pager2.start}&search=${pager2.search}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
							<c:forEach begin="${pager2.start}" end="${pager2.end}" var="i">
								<li class="page-item"><a class="page-link"
									href="./list?page=${i}&search=${pager2.search}">${i}</a></li>
							</c:forEach>

							<li class="page-item ${pager2.next?'':'disabled'}"><a
								class="page-link"
								href="./list?page=${pager2.next?pager2.end+1:pager2.end}&search=${pager2.search}"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>

					<form action="./list" method="get">
						<div class="input-group mb-3">
							<input type="text" class="form-control" placeholder="검색어를 입력하세요"
								aria-label="Recipient's username" name="search"
								aria-describedby="button-addon2">
							<div class="input-group-append">
								<button class="btn btn-outline-secondary" id="button-addon2">검색</button>
							</div>
						</div>
					</form>

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