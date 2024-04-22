package com.shop.repository;

import com.shop.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {

    List<OrderDetail> findByTex(String text);

    @Transactional
    @Modifying
    @Query("DELETE FROM Cart c WHERE c.userrole = :userrole")
    void deleteByUserrole(@Param("userrole") Integer userrole);
}
