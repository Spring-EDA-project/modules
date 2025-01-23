package org.eda.repository.ports.in;

import org.eda.entity.MemberEntity;

public interface MemberRepository {
    MemberEntity save(MemberEntity memberEntity);
}

