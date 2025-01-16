package org.rdbms.impl;

import org.rdbms.entity.MemberEntity;
import org.rdbms.repository.MemberJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberMysqlRepositoryImpl implements MemberRepository {
    @Autowired
    private MemberJpaRepository memberJpaRepository;

    public MemberEntity save(MemberEntity memberEntity) {
        return memberJpaRepository.save(memberEntity);
    }
}
