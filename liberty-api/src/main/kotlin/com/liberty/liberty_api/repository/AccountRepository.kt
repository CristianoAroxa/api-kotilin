package com.liberty.liberty_api.repository

import com.liberty.liberty_api.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long> {
}