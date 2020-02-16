package com.sgic.memberjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgic.memberjpa.model.Member;



@Repository
public interface MemberRepository extends JpaRepository<Member,Integer>{

}
