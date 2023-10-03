package com.example.returnstudy.service;

import com.example.returnstudy.entity.Member;
import com.example.returnstudy.entity.MemberDetails;
import com.example.returnstudy.repository.MemberDetailsRepository;
import com.example.returnstudy.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // final 한정자로 된 필드를 의존성 주입하기 위해한 어노테이션
@Slf4j // 로그 출력을 위한 어노테이션
public class MemberDetailsService {

    private final MemberRepository memberRepository;
    private final MemberDetailsRepository memberDetailsRepository;

    public void OneToOne() {

        Member member = new Member();
        MemberDetails memberDetails = new MemberDetails();

        // memberDetails에 데이터 저장
        memberDetails.setEmail("wnslcosltimo12@khu.ac.kr");
        memberDetails.setPhoneNumber("01010101010");
        memberDetails.setStatusMsg("새학기 시작! 화이팅!");
        memberDetails.setActive(true);
        memberDetailsRepository.save(memberDetails);

        // member에 데이터 저장
        member.setStudentId("2021105614");
        member.setName("신주은");
        member.setGeneration("1st");
        member.setClub("RETURN");
        member.setMemberDetails(memberDetails); // 위에서 저장한 memberDetails 저장
        memberRepository.save(member);

        log.info("saved Member Entity : " + memberRepository.findById(member.getId()).get());

        log.info("saved Member Details Entity : " + memberRepository.findById(member.getId()).get().getMemberDetails());
    }

    @Transactional
    public void OneToOneBidirect() {

        Member member = new Member();
        MemberDetails memberDetails = new MemberDetails();

        // memberDetails에 데이터 저장
        memberDetails.setActive(true);
        memberDetails.setEmail("wnslcosltimo12@khu.ac.kr");
        memberDetails.setPhoneNumber("01010101010");
        memberDetails.setStatusMsg("새학기 시작! 화이팅!");
        memberDetails.setMember(member);
        memberDetailsRepository.save(memberDetails);

        // member에 데이터 저장
        member.setStudentId("2021105614");
        member.setName("신주은");
        member.setGeneration("1st");
        member.setClub("RETURN");
        member.setMemberDetails(memberDetails); // 위에서 저장한 memberDetails 저장
        memberRepository.save(member);

        log.info("saved Member Entity : " + memberRepository.findById(member.getId()).get());

        log.info("saved Member Details Entity : " + memberDetailsRepository.findById(memberDetails.getId()).get());
    }
}
