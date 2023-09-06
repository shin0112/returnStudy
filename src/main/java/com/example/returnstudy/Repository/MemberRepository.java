package com.example.returnstudy.Repository;

import com.example.returnstudy.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{
}
