package com.liberty.liberty_api.service

import com.liberty.liberty_api.model.Account
import java.util.*

interface AccountService {
    fun create(account: Account): Account

    fun getall(): List<Account>

    fun getbyid(id: Long) : Optional<Account>

    fun update(id: Long, account: Account) : Optional<Account>

    fun delete(id: Long)
}