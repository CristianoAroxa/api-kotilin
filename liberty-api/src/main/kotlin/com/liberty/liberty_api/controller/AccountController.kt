package com.liberty.liberty_api.controller

import com.liberty.liberty_api.model.Account
import com.liberty.liberty_api.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/accounts")
class AccountController(private val service: AccountService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody account: Account): Account = service.create(account)

    @GetMapping
    fun getall(): List<Account> = service.getall()

    @GetMapping("/{id}")
    fun getbyid(@PathVariable id: Long) : ResponseEntity<Account> = service.getbyid(id).map {
        ResponseEntity.ok(it)
    }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody account: Account) : ResponseEntity<Account> =
        service.update(id, account).map {

            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity<Void>(HttpStatus.OK)
    }

}