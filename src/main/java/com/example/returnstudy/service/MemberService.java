package com.example.returnstudy.service;

import com.example.returnstudy.dto.MemberRequestDto;
import com.example.returnstudy.dto.MemberResponseDto;
import com.example.returnstudy.entity.Member;
import com.example.returnstudy.entity.MemberDetails;
import com.example.returnstudy.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired //의존성 주입
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //Create
    public MemberResponseDto saveMember(MemberRequestDto memberRequestDto) {

        Member member = new Member();
        member.setStudentId(memberRequestDto.getStudentId());
        member.setName(memberRequestDto.getName());
        member.setGeneration(memberRequestDto.getGeneration());
        member.setClub(memberRequestDto.getClub());
        //save 메소드를 통해 엔티티를 DB에 저장

        MemberDetails memberDetails = new MemberDetails();
        memberDetails.setEmail(memberRequestDto.getEmail());
        memberDetails.setPhoneNumber(memberRequestDto.getPhoneNumber());
        memberDetails.setStatusMsg(memberRequestDto.getStatusMsg());
        memberDetails.setActive(true);

        // 양방향 참조
        member.setMemberDetails(memberDetails);
        memberDetails.setMember(member);

        // Member만 영속화시켜 저장 → DB에 저장
        // Member만 영속 객체일 경우, 영속성 전이로 인해 MemberDetails도 함께 영속 상태가 되며 저장됨
        memberRepository.save(member);

        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto.setId(member.getId());
        memberResponseDto.setStudentId(member.getStudentId());
        memberResponseDto.setName(member.getName());
        memberResponseDto.setGeneration(member.getGeneration());
        memberResponseDto.setClub(member.getClub());
        memberResponseDto.setEmail(memberDetails.getEmail());
        memberResponseDto.setPhoneNumber(memberDetails.getPhoneNumber());
        memberResponseDto.setStatusMsg(memberDetails.getStatusMsg());
        memberResponseDto.setIsActive(memberDetails.isActive());

        return memberResponseDto;
    }

    //Read
    public MemberResponseDto getMember(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            MemberResponseDto memberResponseDto = new MemberResponseDto();
            memberResponseDto.setId(member.get().getId());
            memberResponseDto.setStudentId(member.get().getStudentId());
            memberResponseDto.setName(member.get().getName());
            memberResponseDto.setGeneration(member.get().getGeneration());
            memberResponseDto.setClub(member.get().getClub());
            memberResponseDto.setEmail(member.get().getMemberDetails().getEmail());
            memberResponseDto.setPhoneNumber(member.get().getMemberDetails().getPhoneNumber());
            memberResponseDto.setStatusMsg(member.get().getMemberDetails().getStatusMsg());
            memberResponseDto.setIsActive(member.get().getMemberDetails().isActive());

            return memberResponseDto;
        } else {
            return null;
        }
    }

    //Update
    public MemberResponseDto updateMember(Long id, MemberRequestDto memberRequestDto) {
        Optional<Member> member = memberRepository.findById(id);
        // 영속성 컨텍스트로 member를 영속 객체로 지정 → memberDetails도 같이 영속 상태
        if (member.isPresent()) {
            Member updateMember = member.get();
            updateMember.setStudentId(memberRequestDto.getStudentId());
            updateMember.setName(memberRequestDto.getName());
            updateMember.setGeneration(memberRequestDto.getGeneration());
            updateMember.setClub(memberRequestDto.getClub());

            MemberDetails memberDetails = new MemberDetails();
            memberDetails.setEmail(memberDetails.getEmail());
            memberDetails.setPhoneNumber(memberDetails.getPhoneNumber());
            memberDetails.setStatusMsg(memberDetails.getStatusMsg());
            memberDetails.setActive(true);

            memberRepository.save(updateMember);

            MemberResponseDto memberResponseDto = new MemberResponseDto();
            memberResponseDto.setId(updateMember.getId());
            memberResponseDto.setStudentId(updateMember.getStudentId());
            memberResponseDto.setName(updateMember.getName());
            memberResponseDto.setGeneration(updateMember.getGeneration());
            memberResponseDto.setClub(updateMember.getClub());
            memberResponseDto.setEmail(memberDetails.getEmail());
            memberResponseDto.setPhoneNumber(memberDetails.getPhoneNumber());
            memberResponseDto.setStatusMsg(memberDetails.getStatusMsg());
            memberResponseDto.setIsActive(memberDetails.isActive());

            return memberResponseDto;
        } else {
            return null;
        }
    }

    //Delete
    public boolean isDeleteMember(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            memberRepository.delete(member.get());
            // member 삭제 시, 연관된 memberDetails도 함께 삭제됨
            return true;
        } else {
            return false;
        }
    }

    public void MakeOrphanMemberDetails(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            // Member와 연관관계 제거
            member.get().setMemberDetails(null);
            memberRepository.save(member.get());
        }
    }
}
