package com.liberty.liberty_api.service

import com.liberty.liberty_api.model.Account
import com.liberty.liberty_api.repository.AccountRepository
import org.springframework.stereotype.Service
import org.springframework.util.Assert
import java.util.*

@Service
class AccountServiceImpl(private val repository: AccountRepository) : AccountService {
    override fun create(account: Account): Account {
        Assert.hasLength(account.name, "[nome] is not blank!")
        Assert.isTrue(account.name.length >= 5, "[nome] O nome não pode ter menos que 5 caracteres!")

        return repository.save(account)
    }

    override fun getall(): List<Account> {
        return repository.findAll()
    }

    override fun getbyid(id: Long): Optional<Account> {
        return repository.findById(id)
    }

    override fun update(id: Long, account: Account): Optional<Account> {
        val optional = getbyid(id)
        if (optional.isEmpty) Optional.empty<Account>()

        return optional.map {
            val accountToUpdate = it.copy(
            name = account.name,
            document = account.document,
            phone = account.phone
            )
            repository.save(accountToUpdate)
        }
    }

    override fun delete(id: Long) {
        repository.findById(id).map{
            repository.delete(it)
        }.orElseThrow { throw RuntimeException("Id not found") }

    }
}