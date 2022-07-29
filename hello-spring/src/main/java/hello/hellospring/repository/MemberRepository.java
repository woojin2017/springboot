package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    //저장소에 회원 저장
    Member save(Member member);

    //회원 찾기
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);

    //저장된 모든 리스트 반환
    List<Member> findAll();
}


/*
    Optional
    findBy~는 값이 없을 경우 null을 반환하는데 Optional 이용해 반환
 */