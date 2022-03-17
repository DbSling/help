<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com -->
<html>
<head>
<meta charset="UTF-8">
<!----======== CSS ======== -->
<link rel="stylesheet" href="res/meMg.css">
<!----===== Boxicons CSS ===== -->
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>

<script src="res/js/resource.js"></script>
<script src="res/js/YMember.js"></script>
<!--<title>Dashboard Sidebar Menu</title>-->
</head>
<body onload="getMeMg('${ctCode }')">
	<nav class="sidebar close">
		<header>
			<div class="image-text">
				<span class="image"> <!--<img src="logo.png" alt="">-->
				</span>

				<div class="text logo-text">
					<span class="name">HELP</span> <span class="profession">Health
						Plan </span>
				</div>
			</div>

			<i class='bx bx-chevron-right toggle'></i>
		</header>
		<div class="menu-bar">
			<div class="menu">

				<ul class="menu-links">
					<li class="nav-link"><a href="#"> <i
							class='bx bx-user icon'></i> <span class="text nav-text" onClick="goMePage('${ctCode }')">회원관리</span>
					</a></li>

					<li class="nav-link"><a href="#"> <i
							class='bx bx-group icon'></i> <span class="text nav-text" onClick="goSfPage('${ctCode }')">직원관리</span>
					</a></li>

					<li class="nav-link"><a href="#"> <i
							class='bx bx-chalkboard icon'></i> <span class="text nav-text" onClick="goLessonPage('${ctCode }')">수업관리</span>
					</a></li>

					<li class="nav-link"><a href="#"> <i
							class='bx bx-wrench icon'></i><span class="text nav-text" onClick="goGoodsPage('${ctCode }')">장비관리</span>
					</a></li>

					<li class="nav-link"><a href="#"> <i
							class='bx bx-credit-card icon'></i> <span class="text nav-text" onClick="goPayPage('${ctCode }')">결제관리</span>
					</a></li>


				</ul>
			</div>

			<div class="bottom-content">
				<li class=""><a href="#"> <i class='bx bx-id-card icon'></i>
						<span class="text nav-text">이동명</span> <span class="text nav-text">(트레이너)</span>
				</a></li>

				<li class=""><a href="#"> <i class='bx bx-log-out icon'></i>
						<span class="text nav-text">Logout</span>
				</a></li>

				<li class="mode">
					<div class="sun-moon">
						<i class='bx bx-moon icon moon'></i> <i class='bx bx-sun icon sun'></i>
					</div> <span class="mode-text text">다크모드</span>

					<div class="toggle-switch">
						<span class="switch"></span>
					</div>
				</li>

			</div>
		</div>

	</nav>

	<section class="home">
		<div class="text">회원관리</div>
		<div class="search">
			<span>회원목록</span>
			<div class="nav-search">
				<select>
					<option disabled selected>회원검색</option>
					<option>이름</option>
					<option>연락처</option>
				</select> <select>
					<option disabled selected>회원유형</option>
					<option>일반</option>
					<option>PT</option>
					<option>만료</option>
				</select> <span> <input type="text" placeholder="검색"> <i
					class='bx bx-search icon'></i>
				</span>

			</div>
			<div>
				<button class="InsMember">회원추가</button>
			</div>
		</div>


<table id="ajax"></table>
		<table>
			<thead>
				<tr>
					<td>이름</td>
					<td>성별</td>
					<td>연령</td>
					<td>핸드폰</td>
					<td>유형</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>김한영</td>
					<td>남</td>
					<td>22</td>
					<td>01099241234</td>
					<td>PT</td>
				</tr>
				<tr>
					<td>조본</td>
					<td>남</td>
					<td>29</td>
					<td>01014574123</td>
					<td>만료</td>
				</tr>
				<tr>
					<td>최용희</td>
					<td>여</td>
					<td>28</td>
					<td>01048798545</td>
					<td>PT</td>
				</tr>
				<tr>
					<td>김한일</td>
					<td>남</td>
					<td>19</td>
					<td>01017242234</td>
					<td>일반</td>
				</tr>
				<tr>
					<td>김유일</td>
					<td>여</td>
					<td>52</td>
					<td>01049241324</td>
					<td>PT</td>
				</tr>
			</tbody>
		</table>


	</section>

	<script>
	 const body = document.querySelector('body'),
     sidebar = body.querySelector('nav'),
     toggle = body.querySelector(".toggle"),
     //searchBtn = body.querySelector(".search-box"),
     modeSwitch = body.querySelector(".toggle-switch"),
     modeText = body.querySelector(".mode-text");


	toggle.addEventListener("click" , () =>{
   sidebar.classList.toggle("close");
	})

	modeSwitch.addEventListener("click" , () =>{
   body.classList.toggle("dark");
   
   if(body.classList.contains("dark")){
       modeText.innerText = "라이트모드";
   }else{
       modeText.innerText = "다크모드";
       
   }
	});
	</script>

</body>
</html>
