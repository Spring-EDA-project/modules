package org.rdbms.repository;

import org.rdbms.entity.MemberEntity;
import org.rdbms.repository.ports.in.MemberRepository;
import org.rdbms.repository.ports.out.MemberJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
    @Autowired
    private MemberJpaRepository memberJpaRepository;

    public MemberEntity save(MemberEntity memberEntity) {
        return memberJpaRepository.save(memberEntity);
    }
}
