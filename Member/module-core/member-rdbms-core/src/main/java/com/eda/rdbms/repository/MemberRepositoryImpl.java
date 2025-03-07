package com.eda.rdbms.repository;

import com.eda.global.common.error.GlobalExceptionHandler;
import com.eda.global.common.error.exception.EntityNotFoundException;
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

    @Override
    public MemberEntity findByEmail(String email) {
        GlobalExceptionHandler
        return memberJpaRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public MemberEntity findById(Long id) {
        return memberJpaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
