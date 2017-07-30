# Spring boot example

## 1. Spring data (JPA)를 이용하여 Embedded Database 사용하기
Spring boot는 독립적인 개발 환경을 위해 내장 데이터베이스를 제공한다.

Spring data (JPA)를 사용하여 개발할 때 개발환경에서 데이터베이스를 독립적으로 사용하고 싶으면 내장 데이터베이스를 사용하면 된다.

내장 데이터베이스는 기본적으로 메모리DB를 사용하며, H2, HSQL, Derby를 내장하고 있다.

자세한 내용은 [공식문서](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html)에서 확인할 수 있다.

### 1) pom.xml
pom.xml파일에 JPA와 H2 의존성을 추가한다.

> groupId : org.springframework.boot\
> artifactId : spring-boot-starter-data-jpa 

> groupId : com.h2database\
> artifactId : h2 

### 2) application.properties
입맞에 맞게 JPA설정을 해준다.

> spring.jpa.show-sql=true\
> spring.jpa.generate-ddl=true\
> spring.jpa.hibernate.ddl-auto=update\
> spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect

- spring.jpa.show-sql : JPA에 의해 실행되는 SQL문을 디버그로 보여준다. (기본값 : false)
- spring.jpa.generate-ddl : 데이터베이스를 초기화할지 선택한다. (기본값 : false)
- spring.jpa.hibernate.ddl-auto : 데이터베이스를 초기화하는 방법을 선택한다. (기본값 : none (내장DB사용시 create-drop))
    - create : SessionFactory 시작시 테이블 삭제하고 다시 생성
    - create-drop : create + SessionFactory 종료시 테이블 삭제
    - update : SessionFactory 시작시 컬럼 추가/삭제 수행. 데이터 삭제는 하지 않음
    - validate : SessionFactory 시작시 테이블 컬럼 확인하여 다르면 예외 발생
- spring.jpa.properties.hibernate.dialect : 데이터베이스에 맞는 Hibernate dialect를 선택해준다.

Datasource 설정을 해준다.

아래 예제의 경우 파일DB를 사용하기 위한 설정을 해주었다.

파일DB를 사용할 경우 DB파일의 경로를 지정해주어야 하는데
 
경로가 ./로 시작하게 되면 프로젝트 경로에 DB파일이 생성되며, 절대경로를 지정할수도 있다.

> spring.datasource.url=jdbc:h2:file:./databasename\
> spring.datasource.driver-class-name=org.h2.Driver

- spring.datasource.url : 데이터베이스 URL을 선택한다. 값을 주지 않으면 기본적으로 메모리DB를 사용하며, 서버의 종료와 함께 데이터가 지워진다.
- spring.datasource.driver-class-name : 데이터베이스에 맞는 Driver class를 지정해 준다.

### 3) 예제 돌려보기
CURL 혹은 Postman과 같은 프로그램을 이용하여 테스트를 진행해보자.

User 등록
> request : curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d 'name=kim' localhost:8080/user\
> response : {"id":1,"name":"kim"}

User 조회
> request : curl localhost:8080/user/1\
> response : {"id":1,"name":"kim"}

User 목록 보기
> request : curl localhost:8080/user/show\
> response : [{"id":1,"name":"kim"}]

User 삭제
> request : curl -X DELETE localhost:8080/user/1\
> response : OK

## 2. Spring security 적용해보기

### 1) pom.xml
pom.xml파일에 security 의존성을 추가한다.

> groupId : org.springframework.boot\
> artifactId : spring-boot-starter-security

