# springboot 스프링부트 입문 공부
인프런 강의(https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8)

<H3>MVC, 템플릿 엔진과 API </H3>
1. HelloController 생성 <br>
2. MVC와 API를 이용한 컨트롤러(프로젝트 내에서 사용x)

<h3>회원 도메인과 리포지토리 </h3>
1. 회원 id와 name위한 Member 클래스 작성  <br>
2. 저장을 위한 MemberRepository 인터페이스와 MemoryMemberRepository 클래스 작성

<h3>회원 저장소 테스트 케이스</h3>
1.회원 도메인과 리포지토리 테스트를 위한 MemoryMemberRepositoryTest 작성

<h3>회원 서비스</h3>
1. 중복회원 검증과 전체 회원 조회를 위한 MemberService 클래스 작성 <br>
2. 중복회원이 있을 시 알림

<h3>회원 서비스 테스트</h3>
1. 회원가입 중복 테스트를 위한 MemberServiceTest 클래스 작성

<h3>컴포넌트 스캔과 자동 의존관계</h3>
1. memberController 클레스 작성 <br>
2. memberController, memberService, memberRepository 클래스 연결

<h3>자바 코드로 직접 스프링 빈 </h3>
1. 자바 빈 등록하는 SpringConfig 클래스 작성 <br>
2. @Service, @Repository 미사용

<h3>회원 웹 기능</h3>
<h5>홈 화면 추가</h5>
1. hoem HTML, HomeController 클래스 작성 (http://localhost:8080으로 이동하였을 때 첫 화면)

<h5>등록</h3>
1.MemberForm 클래스, creatememberForm HTML 작성

<h5>조회</h5>
1. memberList HTML 추가

<h3>H2 데이터베이스 설치</h3>
1. H2 데이터베이스 설치 (H2 : 개발이나 테스트 용도로 가볍고 편리한 DB, 웹 화면 제공)
2.데이터 정의하는 ddl.sql 작성

<h3>순수 JDBC</h3>
1. JdbcMemberRepository 클래스 작성

<h3>스프링 통합 테스트</h3>
1. MemberServiceIntegrationTest 테스트 케이스 작성 <br>
2. @Transactional 이용

<h3>스프링 JdbcTemplate </h3>
1.JdncTemplatememberRepository 클래스 작성

<h3>JPA</h3>
1. JpaMemberReopsitory 클래스 

<h3>스프링 데이터 JPA</h3>
1. springDataJpaMemberRepository 인터페이스 작성
