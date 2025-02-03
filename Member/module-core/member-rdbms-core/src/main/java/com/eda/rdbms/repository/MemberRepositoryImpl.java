package com.eda.rdbms.repository;

import lombok.RequiredArgsConstructor;
import com.eda.rdbms.entity.MemberEntity;
import com.eda.rdbms.repository.ports.in.MemberRepository;
import com.eda.rdbms.repository.ports.out.MemberJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
    private final MemberJpaRepository memberJpaRepository;

    public MemberEntity save(MemberEntity memberEntity) {
        return memberJpaRepository.save(memberEntity);
    }
}
