# 우주 여행 프로젝트 Blue Ocean

# 프로젝트 구상

### 프로젝트 기간
2023-05-01~
### ERD
<img src="https://user-images.githubusercontent.com/126591306/236733775-ae90706d-d574-4719-8e3f-38e572133c25.png" width="500" height="400"/> <br/>


### 기능 
#### 회원관리
+ validation과 Ajax를 이용한 회원가입 유효성검사
+ CRUD 회원가입 및 로그인처리
+ 인터셉터를 이용한 메뉴 구성
#### 오픈 API의 JSON 데이터 활용 
+ NASA의 Mars Rover Photos API를 이용하여 원하는 날짜의 화성사진 보여줌
#### 기타기능
+ MessageSource를 이용한 다국어처리


### 앞으로의 계획..
+ 후기 게시판구현
+ Curiosity 도착 4000일 기념 팝업창 만들어보기 (쿠키)
+ nasa api https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY
+ 해당 사진 저장시 회원 프로필 사진으로 갈 수 있도록 만들어보기
+ ajax 댓글
+ 상품판매페이지 
+ spring auth (구글,카카오 로그인 프로그램 만들어보기) 


# 결과

### 회원관리
<img src="https://user-images.githubusercontent.com/126591306/236671489-881f7058-e9b4-4bc2-a6db-9484a21395fe.png" width="500" height="300"/> <br/>
+ validation과 Ajax를 이용한 회원가입 유효성 처리(입력값 패턴 및 길이, 비밀번호 일치여부,아이디 중복여부)


<img src="https://user-images.githubusercontent.com/126591306/236834791-f4e21d07-6474-4179-bf11-09db4d7d3741.png" width="500" height="300"/> <br/>
+ validation을 이용하여 유효성을 검사, 유효성 통과시 아이디와 비밀번호를 통해 DB에 저장되어있는 회원 정보를 UserBean객체에 저장하여, 로그인을 진행<br/>
<img src="https://user-images.githubusercontent.com/126591306/236835910-d882c21b-3e70-4be2-9fd0-d1ac24818df4.png" width="500" height="300"/> <br/>
+ 로그인 실패처리 배너는 로그인을 못한 회원만 볼 수 있도록 설정.
+ 로그인 실패시 location.href에 파라메터값으로 로그인에 실패했다는 값을 바인딩하였음.
+ JSTL의 if조건문을 이용하여 로그인을 못한 회원만 볼 수 있도록 설정


### 오픈API 활용 
#### NASA에서 제공되는 json형식의 데이터를 이용
+ 화성탐사로봇인 Curiosity가 촬영한 사진들을 볼 수 있는 프로그램이며 날짜를 입력하여 특정 날짜에 찍힌 화성의 사진들을 확인 할 수 있음  <br>
<img src="https://user-images.githubusercontent.com/126591306/236594945-0ecd60bb-1d4a-4875-8885-7b408f954aad.png" width="500" height="300"/> <br/>


### 다국어처리
#### MessageSource를 이용하여, Locale에 따라 한국어,영어,독일어로 상단메뉴가 바뀌도록 설정 <br>
+ 사용자의 언어가 en 으로 설정됬을 경우 영어표시 <br>
<img src="https://user-images.githubusercontent.com/126591306/236831574-1376e201-03df-4fd2-88c9-4b29a9e588c3.png" width="500" height="300"/> <br>
+ 사용자의 언어가 de 으로 설정됬을 경우 독일어 표시 <br>
<img src="https://user-images.githubusercontent.com/126591306/236831731-1f9710da-a984-4124-9fe5-3941cfa63511.png" width="500" height="300"/> <br>









# 참고자료
https://api.nasa.gov/
