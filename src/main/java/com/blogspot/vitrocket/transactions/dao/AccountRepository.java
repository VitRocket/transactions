package com.blogspot.vitrocket.transactions.dao;

import com.blogspot.vitrocket.transactions.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by VitRocket on 13.05.2018.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {


}
