package com.liberty.liberty_api.controller.handler

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ExceptionHandler

@Controller
class ErrorHandler {
    @ExceptionHandler(value= [IllegalArgumentException::class])
    fun illegalArgumentException(request: HttpServletRequest, exception: Exception): ResponseEntity<ErrorResponse> {
        val errorResponse= ErrorResponse(statusCode = HttpStatus.BAD_REQUEST.value(), message = exception.message!!)
        return ResponseEntity.badRequest().body(errorResponse)
    }
}

data class ErrorResponse (val statusCode: Int, val message : String)


