package com.example.returnstudy.Service;

import com.example.returnstudy.DTO.*;
import com.example.returnstudy.Entity.Member;
import com.example.returnstudy.Repository.MemberRepository;
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
    public MemberResponseDto saveMember(MemberDto memberDto) {
        Member member = new Member();
        member.setStudentId(memberDto.getStudentId());
        member.setName(memberDto.getName());
        member.setGeneration(memberDto.getGeneration());
        member.setClub(memberDto.getClub());

        //save 메소드를 통해 엔티티를 DB에 저장
        memberRepository.save(member);
        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto.setId(member.getId());
        memberResponseDto.setStudentId(member.getStudentId());
        memberResponseDto.setName(member.getName());
        memberResponseDto.setGeneration(member.getGeneration());
        memberResponseDto.setClub(member.getClub());

        return memberResponseDto;
    }

    //Read
    public MemberResponseDto getMember(Long id) {
        //findById 메소드를 통해 id(Pk값)로 해당 엔티티를 가져옴
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            MemberResponseDto memberResponseDto = new MemberResponseDto();
            memberResponseDto.setId(member.get().getId());
            memberResponseDto.setStudentId(member.get().getStudentId());
            memberResponseDto.setName(member.get().getName());
            memberResponseDto.setGeneration(member.get().getGeneration());
            memberResponseDto.setClub(member.get().getClub());

            return memberResponseDto;
        } else {
            return null;
        }
    }

    //Update
    public MemberResponseDto updateMember(Long id, MemberDto memberDto) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            Member updateMember = member.get();
            updateMember.setStudentId(memberDto.getStudentId());
            updateMember.setName(memberDto.getName());
            updateMember.setGeneration(memberDto.getGeneration());
            updateMember.setClub(memberDto.getClub());
            //Dirty Checking을 통해 영속 상태의 엔티티와 수정된 엔티티를 비교 → 갱신된 필드만 저장
            memberRepository.save(updateMember);

            MemberResponseDto memberResponseDto = new MemberResponseDto();
            memberResponseDto.setId(updateMember.getId());
            memberResponseDto.setStudentId(updateMember.getStudentId());
            memberResponseDto.setName(updateMember.getName());
            memberResponseDto.setGeneration(updateMember.getGeneration());
            memberResponseDto.setClub(updateMember.getClub());

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
            return true;
        } else {
            return false;
        }
    }
}
