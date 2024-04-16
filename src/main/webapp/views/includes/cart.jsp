<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 장바구니 모달 -->
<div class="modal fade" id="cartModal" tabindex="-1" role="dialog"
	aria-labelledby="cartModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered modal-lg"
		role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="cartModalLabel">장바구니</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<div id="cartList"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<button type="button" class="btn btn-secondary float-right"
								data-dismiss="modal">닫기</button>
							<button type="button" class="btn btn-danger float-right mr-2"
								onclick="deleteSelectedItems()">선택된 상품 삭제</button>
							<button type="button" class="btn btn-success float-right mr-2"
								onclick="buySelectedItems()">선택된 상품 구매</button>
							<a href="NewFile.html">테스트</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>