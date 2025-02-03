package com.eda.rdbms.repository.ports.in;

import com.eda.rdbms.entity.MemberEntity;

public interface MemberRepository {
    MemberEntity save(MemberEntity memberEntity);
}

