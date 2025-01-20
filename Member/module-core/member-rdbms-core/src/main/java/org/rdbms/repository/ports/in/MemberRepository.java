package org.rdbms.repository.ports.in;

import org.rdbms.entity.MemberEntity;

public interface MemberRepository {
    MemberEntity save(MemberEntity memberEntity);
}

