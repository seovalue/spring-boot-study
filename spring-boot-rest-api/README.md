## REST API using Spring Boot

### 시나리오
사용자와 관련된 REST API 제작, (사용자가 작성하는 간단한 글)  
- 한명의 사용자는 여러개의 포스팅 가능  
	-> User와 Posts는 1대다의 관계를 가진다.  

제공하는 기능: `조회, 생성, 삭제 기능`  

Description|REST API|HTTP Method
------------|----------|----------
전체 사용자 조회|/users|GET
사용자 생성|/users|POST
특정 사용자 조회|/users/{id}|GET
특정 사용자 삭제|/users/{id}|DELETE
사용자의 모든 포스트 조회|/users/{id}/posts|GET
사용자의 포스트 생성|/users/{id}/posts|POST
사용자의 상세 정보 조회|/users/{id}/posts/{post_id}|GET


## 과정
1. HelloWorldController를 등록하여 web과 POSTMAN을 통해 확인해봄.  
![](./README_img/commit_1.PNG)  
![](./README_img/commit_1_1.PNG)  
2. HelloWorldBean을 등록한 뒤, '/hello-world-bean'으로 요청이 들어오는 경우 message를 JSON 형태로 반환  
- lombok 플러그인을 사용하였다. (getter, setter, constructor가 모두 자동으로 등록됨.. 😮)  
- RestController Annotation을 활용하면 반환시키고자 하는 데이터 값을 Response Body에 저장하지 않더라도 자동으로 JSON 포맷으로 변경되어 반환됨.  
![](./README_img/commit_2.PNG)  
![](./README_img/commit_2_1.PNG)  
3. DispatcherServlet과 프로젝트 동작의 이해  
- DispatcherServlet이란?  
    클라이언트의 모든 요청을 한 곳으로 받아서 처리
    요청에 맞는 핸들러로 요청을 전달
    핸들러의 실행 결과를 http Response 형태로 만들어서 반환  
    ![](./README_img/commit_3.PNG)  
- RestController  
![](./README_img/commit_3_1.PNG)  

