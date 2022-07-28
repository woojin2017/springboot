package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //테스트가 실행되고 끝날때마다 저장소를 지운다
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        //member와 result 가 같은지 확인
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByname(){
        Member member1 = new Member();
        member1.setName("spring11");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring22");
        repository.save(member2);

        Member result = repository.findByName("spring11").get();
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring11");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring22");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
