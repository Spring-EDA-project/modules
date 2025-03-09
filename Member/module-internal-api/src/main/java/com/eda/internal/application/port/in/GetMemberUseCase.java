package com.eda.internal.application.port.in;

import com.eda.domain.Member;

public interface GetMemberUseCase {
    Member getMemberInfo(Long id);

}
