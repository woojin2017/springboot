package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    /*
    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository()
        MemberService의 MemoryMemberRepository 와 MemberServiceTest의 MemoryMemberRepository가 다르다
     */

    MemberService memberService;
    MemoryMemberRepository memberRepository;


    @BeforeEach
    public void beforEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        /*
            * given 무언가가 주어지고
            * when  이거를 실행 했을 때
            * then  결과가 이게 나와야 한다
        */

        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");



        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        /*
        try{
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        }
            try{}catch(){} 대신 밑에 방법 사용 가능
         */

        // memberService.join(member2) 부분을 실행하면 IllegalstateException 오류가 되어야 한다
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}