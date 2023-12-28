package hello.servlet.domain.member;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MemberRepositoryTest {
    
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void AfterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("kwon", 23);
        
        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member finMember = memberRepository.findById(savedMember.getId());
        Assertions.assertThat(finMember).isEqualTo(savedMember);

    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("mem1", 23);
        Member member2 = new Member("mem2", 33);

        memberRepository.save(member1);
        memberRepository.save(member2);
        
        //when
        List<Member> result = memberRepository.findAll();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(member1, member2);
    }
}
