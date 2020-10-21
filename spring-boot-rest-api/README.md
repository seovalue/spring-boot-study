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
