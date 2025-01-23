package org.eda.repository;

import lombok.RequiredArgsConstructor;
import org.eda.entity.MemberEntity;
import org.eda.repository.ports.in.MemberRepository;
import org.eda.repository.ports.out.MemberJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
    private final MemberJpaRepository memberJpaRepository;

    public MemberEntity save(MemberEntity memberEntity) {
        return memberJpaRepository.save(memberEntity);
    }
}
