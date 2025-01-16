package org.rdbms.impl;

import org.rdbms.entity.MemberEntity;

public interface MemberRepository {
    MemberEntity save(MemberEntity memberEntity);
}

