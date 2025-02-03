package com.eda.rdbms.repository.ports.out;

import com.eda.rdbms.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {
}

