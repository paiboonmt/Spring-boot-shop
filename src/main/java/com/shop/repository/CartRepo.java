package com.shop.repository;

import com.shop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CartRepo extends JpaRepository< Cart , Integer >  {

    @Transactional
    @Modifying
    @Query("DELETE FROM Cart c WHERE c.userrole = :userrole")
    void deleteByUserrole(@Param("userrole") Integer userrole);

}
