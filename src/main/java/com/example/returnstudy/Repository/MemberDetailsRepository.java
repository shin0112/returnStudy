package com.example.returnstudy.Repository;

import com.example.returnstudy.Entity.MemberDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDetailsRepository extends JpaRepository<MemberDetails, Long> {
}
