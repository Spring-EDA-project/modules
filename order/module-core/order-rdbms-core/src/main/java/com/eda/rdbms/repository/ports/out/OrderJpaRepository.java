package com.eda.rdbms.repository.ports.out;

import com.eda.rdbms.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {

    @Query("SELECT MAX(o.id) FROM OrderEntity o WHERE o.id >= :prefixStart AND o.id < :prefixEnd")
    Optional<Long> findMaxOrderIdInRange(@Param("prefixStart") Long prefixStart, @Param("prefixEnd") Long prefixEnd);
}
