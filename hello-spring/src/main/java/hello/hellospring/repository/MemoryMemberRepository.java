package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository
{
    //svae 하기 위한 Map 생성
    private static Map<Long,Member> store = new HashMap<>();    //long은 key Member는 values

    //키 값 생성을 위한 sequence
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        //member은 사용자이름으로 사용자로부터 받는다
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    //id 찾기
    @Override
    public Optional<Member> findById(Long id) {
        //null이 나올 경우를 대비해 Optional.ofNullable 사용
        return Optional.ofNullable(store.get(id));
    }

    //아이디 또는 이름 찾기
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    // id와 name 찾기기
   @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
