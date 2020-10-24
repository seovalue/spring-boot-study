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
- `lombok` 플러그인을 사용하였다. (`getter`, `setter`, `constructor`가 모두 자동으로 등록됨.. 😮)  
- `RestController Annotation`을 활용하면 반환시키고자 하는 데이터 값을 Response Body에 저장하지 않더라도 자동으로 JSON 포맷으로 변경되어 반환됨.  
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

4. url에 가변 변수 사용  
![](./README_img/commit_4.PNG)  

5. User 도메인 클래스 생성  
- user package 생성  
- 하위에 User 클래스와 UserDaoService라는 DB 이용 오브젝트 서비스 클래스 생성 
 
6. 사용자 목록 조회를 위한 api 구현 - get http
![](./README_img/commit_6.PNG)  
![](./README_img/commit_6_1.PNG)   

7. 사용자 등록을 위한 api 구현 - post method  
같은 url이어도 method에 따라서 하는 역할이 달라진다.  
![](./README_img/commit_7.PNG)  
![](./README_img/commit_7_1.PNG)  

8. HTTP STATUS CODE 제어  
서버에서 반환시켜주고자 하는 값을 `ResponseEntitiy`에 담아서 전달.  
이 예제에서는 userid가 서버에서 생성되므로 그를 포함한 `uri`를 리턴한다.
rest api를 개발할 때, 예외 핸들링을 조합해서 적절한 `http status code`를 전달하는 것이 좋다. 작업 용도에 맞춰서 http 리소스의 상태를 담아서 전달하자!
![](./README_img/commit_8.PNG)  

9. HTTP Status Code 제어를 위한 Exception Handling
![](./README_img/commit_9.PNG)  
존재하지 않는 유저를 조회했을 때, 존재하지 않지만 오류는 아니기에 (기존: null을 리턴하도록 함) 2xx의 코드를 나타냈었다.  
따라서, 존재하지 않는 유저를 조회하면 not found 에러가 발생할 수 있도록 변경한다. 하지만 이때는 5xx 에러가 발생하기 때문에 404 not found로 변경하기 위해 @ResponseStatus를 활용하여 not found가 뜨도록 변경하였다.
![](./README_img/commit_9_1.PNG)  

10. AOP를 활용한 예외 처리  
9.에서는 에러가 발생했을 때 trace를 통해 내부 코드와 관련된 정보가 담길 수도 있었다.
이번에는 aop를 활용하여 `CustomizedResponseEntityExceptionHandler` 클래스를 생성하여 에러가 발생했을 때 우리가 전달하고 싶은 정보만 담아서 전달할 수 있도록 구성하였다.  
![](./README_img/commit_10.PNG)  

11. 사용자 삭제를 위한 api 구현 - DELETE METHOD  
입력된 id에 해당하는 사용자를 delete method를 활용하여 삭제하는 것을 구현해보았다.  
![](./README_img/commit_11.PNG)  
![](./README_img/commit_11_1.PNG)  

12. 사용자 수정을 위한 api 구현 - PUT METHOD  
입력된 User 객체의 id와 일치하는 사용자가 존재한다면, 기존의 user 정보를 새롭게 입력된 user 정보로 업데이트한다.  
![](./README_img/commit_12.PNG)  
![](./README_img/commit_12_1.PNG)  

13. 유효성 체크를 위한 Validation API 사용  
User 클래스에 Validation을 추가한다. 이름은 최소 2글자 이상, Date는 과거의 일자만 입력할 수 있도록 하는 조건을 추가했다.  
이후 Postman을 통해 확인해본 결과는 다음과 같다. 조건을 만족시키지 않는 경우에는 404 Bad Request Status code를 나타내며, Status code 이외에
body에 에러 메시지를 담기 위해 `CustomizedResponseEntityExceptionHandler`에 Not Valid에 대한 에러 핸들러도 추가하였다.  
![](./README_img/commit_13.PNG)  
![](./README_img/commit_13_1.PNG)  

14. 다국어 처리를 위한 Internationalization 구현  
먼저, `@SpringBootApplication` 어노테이션이 있는 java 파일에`LocaleResolver`라는 `@Bean`을 등록한다.
이후, `messages.properties`를 en, fr 그리고 기본(ko)으로 생성한 뒤, `Controller`에서 `Header`에 들어오는 정보에 따라 알맞은 언어로 처리해주도록 설정하였다.  
* POSTMAN에서 한글이 깨지는 현상이 발생했다. 이는 Intellj에서 UTF-8 인코딩 설정을 한 뒤, 재실행하면 해결되었다.  

![](./README_img/commit_14.PNG)  
![](./README_img/commit_14_1.PNG) 

15. Response 데이터 형식 변환 -XML 포맷  
헤더의 VALUE로 `application/xml` 형태로 요청했을 때 적절한 형식으로 변환하여 처리하기 위해 라이브러리를 추가한다.  
```
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
    <version>2.10.2</version>
</dependency>
```
![](./README_img/commit_15.PNG)


