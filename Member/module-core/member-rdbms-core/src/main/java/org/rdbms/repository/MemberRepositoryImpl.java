package org.rdbms.repository;

import lombok.RequiredArgsConstructor;
import org.rdbms.entity.MemberEntity;
import org.rdbms.repository.ports.in.MemberRepository;
import org.rdbms.repository.ports.out.MemberJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
    private final MemberJpaRepository memberJpaRepository;

    public MemberEntity save(MemberEntity memberEntity) {
        return memberJpaRepository.save(memberEntity);
    }
}
