<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 상품 목록 -->
<div class="container mt-3">
	<div class="row">
		<c:forEach var="i" begin="1" end="8">
			<c:set var="productListName" value="productList${i}" />
			<c:set var="productList" value="${requestScope[productListName]}" />
			<c:if test="${not empty productList}">
				<h5 class="card-title">카테고리 ${i}</h5>
				<div class="overflow-auto" style="white-space: nowrap;">
					<div class="col-md-3 mb-2">
						<div class="d-flex flex-nowrap">
							<c:forEach var="product" items="${productList}">
								<div class="mr-2">
									<div class="card" style="width: 14.7rem;">
										<img src="upload/${product.pictureUrl}" class="card-img-top"
											alt="Product Image" id="image${product.code}">
										<div class="card-body">
											<h6 class="card-title" id="name${product.code}">${product.productName}</h6>
											<p class="card-text" id="price${product.code}">가격:
												${product.price}원</p>
											<input type="number" id="quantity${product.code}" min="0"
												value="1">
											<div>
												<button class="btn btn-primary"
													onclick="addToCart(${product.code}, updateCart)">장바구니</button>
												<button class="btn btn-success"
													onclick="purchase(${product.code})">구매</button>
											</div>
										</div>
										<div class="card-footer">
											<p class="text-muted">상품 요약: ${product.description}</p>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</div>
</div>