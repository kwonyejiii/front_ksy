package com.Board.dto;
//Service Layer에서 API를 처리 :DTO, Service
//게시글 정보를 리턴할 응답(Response) DTO 클래스,
// 게시판 게시글 정보를 클라이언트로 응답하기 위한 데이터 전송 객체인 BoardResponseDto( 게시글 조회 API와 같이 클라이언트에 응답할 때 사용)
  // 이 클래스의 생성자는 Board 엔티티 객체를 매개변수로 받아서 해당 엔티티의 필드 값을 BoardResponseDto의 필드에 복사합니다. 이렇게 함으로써 엔티티에서 필요한 정보를 추출하여 클라이언트에게 전달할 수 있습니다.
import java.time.LocalDateTime;


import com.Board.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {

    private Long id; // PK
    private String title; // 제목
    private String content; // 내용
    private String writer; // 작성자
    private int hits; // 조회 수
    private char deleteYn; // 삭제 여부
    private LocalDateTime createdDate; // 생성일
    private LocalDateTime modifiedDate; // 수정일

    //생성자    (엔티티 객체의 필드 값을 DTO 객체의 필드에 복사하여 값을 설정)
              //매개변수로 받은 Board 엔티티 객체를 기반으로 BoardResponseDto 객체를 생성하고 초기화
        // Board 엔티티 객체의 정보를 BoardResponseDto 객체로 복사하고 초기화하면, 클라이언트에 응답으로 전송할 데이터를 BoardResponseDto 객체에 담을 수 있ㄷ.
    public BoardResponseDto(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
        this.hits = entity.getHits();
        this.deleteYn = entity.getDeleteYn();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
