## Spring GO GO GO!!

## IOC

Dependency(의존성)

unit test

## DL(Dependency Lookup)

## DI(Dependency Injection)

    - 의존성이 줄어든다.
    - 가독성이 높아짐
    - 단위테스트가 쉬워진당...

## AOP(Aspect Oriented Programming)

-   관점 지향 프로그램

java -> aop 기능을 spring이 해줌

spring은 mvc model 2 방식

model - 데이터 처리 담당, service 영역 / DAO영역

Controller - 사용자 interface를 담당

## POJO(Plain Old Java Object)

## Spring boot

-   Spring framework 셋팅하는 과정을 축약

1. Spring batch 어떠한 순간에 어떠한 일들을 한꺼번에 실행
2. Spring security 보안관련

## Spring도 관습적으로 처리되는 부분이 있기 때문에 켠벤션 룰을 잘 지켜야 함.

## @SpringBootApplication

-   @Configuration(각종 설정)
-   -   @EnableAutoConfiguration(application context 관련 자동 설정)
-   -   @ComponentScan
-   (@Component @Configuration이 붙은 클래스를 스캔하여 빈 등록)

## spring security

-   제공되어 있는 시큐리티를

## Spring Boot DevTools(05.03)

-   Property Defaults : 캐싱기능 관련
-   Automatic Restart
-   Live Reload
-   Global Settings
-   Remote Applications

## ThymeLeaf

```html
<html xmlns:th="http://www.thymeleaf.org"></html>
```

-   th:each 반복
-   th:text 출력
-   th:if 조건 true
-   th:unless 조건 false
-   th:switch 조건에 따른 값
-   th:case 조건에 따른 값
-   th:with 값을 다른 변수에 재 할당.

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta charset="UTF-8" />
        <title>Title</title>
    </head>
    <body>
        <h1>상품 리스트 보기</h1>
        <table border="1">
            <thead>
                <tr>
                    <td>순번</td>
                    <td>상품명</td>
                    <td>상품설명</td>
                    <td>가격</td>
                    <td>상품등록일</td>
                </tr>
            </thead>
            <tbody>
                <tr th:each=" itemDto, status : ${itemDtoList}">
                    <td th:if="${status.even}" th:text="짝수"></td>
                    <td th:unless="${status.even}" th:text="홀수"></td>
                    <td th:text="${itemDto.itemNm}"></td>
                    <td th:text="${itemDto.itemDetail}"></td>
                    <td th:text="${itemDto.price}"></td>
                    <td th:text="${itemDto.regTime}"></td>
                </tr>
            </tbody>
        </table>
        <table border="1">
            <thead>
                <tr>
                    <td>순번</td>
                    <td>상품명</td>
                    <td>상품설명</td>
                    <td>가격</td>
                    <td>상품등록일</td>
                </tr>
            </thead>
            <tbody>
                <tr th:each=" itemDto, status : ${itemDtoList}">
                    <td th:switch="${status.even}">
                        <span th:case="true">짝수</span>
                        <span th:case="false">홀수</span>
                    </td>
                    <td th:with="name=${itemDto.itemNm}" th:text="${name}"></td>
                    <td th:with="name=${itemDto.itemNm}" th:text="${name}+'의 '+${itemDto.itemDetail}"></td>
                    <td th:text="${itemDto.itemDetail}"></td>
                    <td th:text="${itemDto.price}"></td>
                    <td th:text="${itemDto.regTime}"></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
```

-   th:href 링크처리

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta charset="UTF-8" />
        <title>Title</title>
    </head>
    <body>
        <h1>Thymeleaf 링크 처리</h1>
        <div>
            <a th:href="@{/thymeleaf/ex01}">페이지 이동</a>
        </div>
        <div>
            <a th:href="@{https://www.thymeleaf.org}">타임리프 공홈</a>
        </div>
        <div>
            <a th:href="@{/thymeleaf/ex06(param1='파라미터1',param2='파라미터2')}">매개변수 페이지 이동</a>
        </div>
    </body>
</html>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta charset="UTF-8" />
        <title>Title</title>
    </head>
    <body>
        <h1>파라미터 전달</h1>
        <div th:text="${param1}"></div>
        <div th:text="${param2}"></div>
    </body>
</html>
```

-   layout:fragment
-   th:fragment
-   th:block
-   th:replace

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
    <head>
        <meta charset="UTF-8" />
        <title>Title</title>
        <th:block layout:fragment="script"></th:block>
        <th:block layout:fragment="css"></th:block>
    </head>
    <body>
        <div th:replace="fragment/header::header"></div>
        <div layout:fragment="content" class="content"></div>
        <div th:replace="fragment/footer::footer"></div>
    </body>
</html>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <div th:fragment="footer">footer area</div>
</html>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <div th:fragment="header">Header area</div>
</html>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorate="~{layouts/layout1}">
    <div layout:fragment="content">본문 영역</div>
</html>
```

-   th:action

## Validation

-   @NotEmpty - Null 체크 및 문자열 길이(0) 검사
-   @NotBlack - Null 체크 및 문자열 길이(0) 및 빈 문자열("") 검사
-   @Length(min=, max=) 최소, 최대 길이 검사
-   @Email - 이메일 형식 검사
-   @Max(숫자) @min(숫자) - 지정 값 대소 검사
-   @Null - Null 인지 검사
-   @NotNull - Null 이 아닌지 검사

## JPA

-   @Id
-   @Column
-   @GeneratedValue
-   @OneToOne
-   @OneToMany
-   @ManyTOMany
-   @ManyToOne
-   JoinColumn

## 즉시로딩

## 지연로딩
