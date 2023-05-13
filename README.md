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
+ 인터셉터를 이용한 로그인 회원전용 메뉴 및 기능 구성
### 게시판 CRUD 구현
++ 여행 후기 게시판 CRUD 기능
#### 오픈 API의 JSON 데이터 활용 
+ NASA의 Mars Rover Photos API를 이용하여 원하는 날짜의 화성사진 보여줌
+ NASA의 Astronomy Picture of the Day API를 이용하여 NASA가 선정한 오늘 날짜의 우주사진을 보여줌 
+ 로그인한 회원은 Astronomy Picture of the Day API로 전달받은 사진을 자신의 프로필 페이지로 데이터처리 가능 (CRUD)
#### 다국어 처리기능
+ 사용자의 브라우저 언어 중 한국어,영어,독일어는 각각 홈화면의 언어구성을 다르게 함. 언어설정 없을시 한국어


### 앞으로의 계획..
+ Curiosity 도착 4000일 기념 팝업창 만들어보기 (쿠키)
+ nasa api https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY
+ 해당 사진 저장시 회원 프로필 사진으로 갈 수 있도록 만들어보기 (회원 프로필 설정) 
+ ajax 댓글
+ ajax 자리 예약 시스템 (json데이터 직접만들어서 구현하기) 
+ 상품판매페이지 
+ spring auth (구글,카카오 로그인시스템적용 ) 


# 결과




# 참고자료
https://api.nasa.gov/
