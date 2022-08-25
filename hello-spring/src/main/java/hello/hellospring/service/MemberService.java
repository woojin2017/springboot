package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/*
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    //직접 생성이 아니라 외부에서 넣어줌 DIR
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    //회원가입
    public long join(Member member){


        validateDup(member);                //중복 회원 검증
        memberRepository.save(member);      //저장
        return member.getId();
    }

    private void validateDup(Member member) {
    /*
    *같은 이름이 있는 중복 회원x
    *Optional은 null일 가능성이 있으면 Optional로 감싸준다

    Optional<Member> result = memberRepository.findByName(member.getName());

    *ifPresent() {}-> 만약 ()값이 있으면 {} 실행

        result.ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });

    *위에 거를 정리하면 아래처럼 간결하게 나타낼 수 있다

        memberRepository.findByName(member.getName())
        //ifPresent() {}-> 만약 ()값이 있으면 {} 실행
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }


      //전체 회원 조회

    public List<Member> findMembers(){
       return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memeberId){
        return memberRepository.findById(memeberId);
    }

}
*/
@Transactional
//java 코드로 직접 스프링 빈 등록하기
public class MemberService {
    private final MemberRepository memberRepository;

    //직접 생성이 아니라 외부에서 넣어줌 DIR
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    //회원가입
    public long join(Member member){


        validateDup(member);                //중복 회원 검증
        memberRepository.save(member);      //저장
        return member.getId();
    }

    private void validateDup(Member member) {
/*
    *같은 이름이 있는 중복 회원x
    *Optional은 null일 가능성이 있으면 Optional로 감싸준다

    Optional<Member> result = memberRepository.findByName(member.getName());

    *ifPresent() {}-> 만약 ()값이 있으면 {} 실행

        result.ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });

    *위에 거를 정리하면 아래처럼 간결하게 나타낼 수 있다
 */
        memberRepository.findByName(member.getName())
                //ifPresent() {}-> 만약 ()값이 있으면 {} 실행
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    /*
        전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memeberId){
        return memberRepository.findById(memeberId);
    }

}
