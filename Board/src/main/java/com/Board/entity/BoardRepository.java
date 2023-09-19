package com.Board.entity;
//'엔티티(Entity)' 클래스와 '레파지토리'(Repository) 인터페이스는 꼭! 같은 패키지에 위치!!
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board,Long> {
}


/*    엔티티와 상호작용하기 위한 JPA 리포지토리.
        이 리포지토리를 통해 데이터베이스와의 CRUD(Create, Read, Update, Delete) 작업을 수행*/
/*
  # 레파지토리 인터페이스에서 JpaRepository 인터페이스를 상속받을 때,
    엔티티 클래스의 타입(Board)과 PK에 해당하는 데이터 타입(Long)을 선언하면,
    해당 엔티티 클래스와 매핑되는 테이블인 board 테이블의 CRUD 기능을 사용할 수 있다. >

        "board 테이블의 CRUD 쿼리를 자동으로 생성해주는 레파지토리 인터페이스"를 생성해
        JpaRepository<T, ID> 인터페이스를 상속받음


// JPA의 Repository = MyBatis의 Mapper
        Repository는 MyBatis의 SQL Mapper와 유사한 퍼시스턴스 영역에 사용되는 인터페이스*/
