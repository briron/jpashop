package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired private MemberRepository memberRepository;

    @Test
    @Transactional
    public void testMember() {
        // given
        Member member = new Member();
        member.setName("Member A");

        // when
        Long memberId = memberRepository.save(member);
        Member findMember = memberRepository.findOne(memberId);

        // then
        assertThat(member.getId()).isEqualTo(findMember.getId());

    }

}