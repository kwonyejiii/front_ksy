package com.Board.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
//데이터베이스 테이블과 매핑되는 클래스로, 데이터베이스 레코드
@Getter // 해당 클래스 멤버 변수 모든 getter 생성 롬복의 기능
@NoArgsConstructor(access = AccessLevel.PROTECTED)   // 해당 클래스 기본 생성자 생성 어노테이션 access 속성 이용 동일 패키지 내 클래스 객체 생성 제어
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // PK 생성 전략 설정 어노테이션 MySQL 자동 증가(AUTO_INCREMENT) 지원 DB PK 자동 증가 지원
    private Long id; // PK

    private String title; // 제목

    private String content; // 내용

    private String writer; // 작성자

    private int hits; // 조회 수

    private char deleteYn; // 삭제 여부

    private LocalDateTime createdDate = LocalDateTime.now(); // 생성일

    private LocalDateTime modifiedDate; // 수정일

    @Builder
    public Board(String title, String content, String writer, int hits, char deleteYn) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.hits = hits;
        this.deleteYn = deleteYn;
    }
    //Entity 클래스에 게시글 수정 기능 추가하기!
    public void update(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.modifiedDate = LocalDateTime.now();
    }

}

//@Entity // 해당 클래스 테이블 매핑 JPA 엔티티 클래스 의미 기본적으로 클래스명 Camel Case 테이블명 Snake Case 매핑 (예를 들어 user_role 테이블 UserRole 클래스) 네이밍 혹시라도 클래스명 테이블명 다를 수 있는 상황 클래스 레벨 @Table 선언 @Table(name = "user_role") name 속성 이용 처리
//@Id // 해당 멤버 엔티티 PK 의미 보통 MySQL DB PK bigint 타입 엔티티 Long 타입 선언 데이터 양 그리 많지 않은 경우 Integer 사용 될 듯
//@Builder는 롬복에서 제공하는 빌더 패턴을 사용하는 어노테이션으로, "생성자 대신에 사용, 객체를 생성할 때 매개변수가 많을 때 유용!"
//Entity 클래스에는 setter 메서드가 존재X:  엔티티 클래스는 테이블 그 자체컬럼에 대한 setter를 자동으로 생성하면 객체의 값이 언제 변경되었는지 추적하기 어려워짐

