package com.Board.model;

import java.util.List;
import java.util.stream.Collectors;

import com.Board.dto.BoardRequestDto;
import com.Board.dto.BoardResponseDto;
import com.Board.entity.Board;
import com.Board.entity.BoardRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Board.exception.ErrorCode;

import lombok.RequiredArgsConstructor;
// 서비스 클래스는 주로 컨트롤러 클래스와 함께 사용되며, HTTP 요청을 받아 처리하거나, 데이터베이스와의 상호작용을 담당합니다. 이를 통해 클라이언트와 데이터베이스 사이의 중간 계층 역할을 하며, 비즈니스 로직을 구현
@Service
@RequiredArgsConstructor //클래스 내에 final로 선언된 모든 멤버변수에 대한 생성자 만들어줌(롬복), 생성자는 해당 클래스의 멤버 변수를 초기화하는 데 사용
public class BoardService {

    private final BoardRepository boardRepository;  /*    엔티티와 상호작용하기 위한 JPA 리포지토리. 이 리포지토리를 통해 데이터베이스와의 CRUD(Create, Read, Update, Delete) 작업을 수행*/

    /**
     * 게시글 생성
     * BoardRequestDto 객체를 매개변수로 받아서, 해당 DTO를 Board 엔티티로 변환한 후 boardRepository.save()를 통해 데이터베이스에 저장합니다. 게시글이 성공적으로 저장되면 게시글의 ID를 반환
     */
    @Transactional  //JPA를 사용한다면, 서비스(Service) 클래스에서 필수적으로 사용되어야 하는 어노테이션입니다.일반적으로 메서드 레벨에 선언하게 되며, 메서드의 실행, 종료, 예외를 기준으로각각 실행(begin), 종료(commit), 예외(rollback)를 자동으로 처리해 줍니다.
    public Long save(final BoardRequestDto params) {

        Board entity = boardRepository.save(params.toEntity());
        return entity.getId();
    }

    /**
     * 게시글 리스트 조회
     * 가져온 엔티티를 BoardResponseDto로 변환한 후 리스트로 반환합니다. 결과는 id와 createdDate 기준으로 내림차순으로 정렬
     */
    public List<BoardResponseDto> findAll() {

        Sort sort = Sort.by(Direction.DESC, "id", "createdDate");
        List<Board> list = boardRepository.findAll(sort);
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    /**
     * 게시글 수정
     * 수정할 게시글의 ID와 수정할 내용을 포함한 BoardRequestDto 객체를 매개변수로 받습니다. 먼저 boardRepository.findById(id)를 사용하여 해당 ID의 게시글을 조회합니다. 만약 게시글이 존재하지 않으면 CustomException을 발생시킵니다. 게시글이 존재하면 엔티티를 업데이트하고, 변경된 ID를 반환
     */
    @Transactional
    public Long update(final Long id, final BoardRequestDto params) {

        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.update(params.getTitle(), params.getContent(), params.getWriter());
        return id;
    }

}
