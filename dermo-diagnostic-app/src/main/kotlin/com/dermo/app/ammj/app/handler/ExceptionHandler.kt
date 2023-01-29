package com.dermo.app.ammj.app.handler

import com.dermo.app.ammj.common.environment.VisionEnvironment.Companion.APP_NAME
import com.dermo.app.ammj.common.exception.DiagnosticException
import com.dermo.app.ammj.common.response.ErrorResponse
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {

    private val logger = LoggerFactory.getLogger(this.javaClass.name)
    private val teamCode = "00C"
    private val microserviceId = "1333"

    /**
     * Handles DiagnosticException
     * @see com.dermo.app.ammj.common.exception.DiagnosticException.kt
     */
    @ExceptionHandler(DiagnosticException::class)
    fun handleDiagnosticException(ex: DiagnosticException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            status = ex.status,
            message = ex.errorCode
        )
        logger.error(
            "--{} --ExceptionHandler:handleDiagnosticException --status: [{}] --message: [{}]",
            APP_NAME, errorResponse.status, errorResponse.message
        )
        return ResponseEntity.status(ex.status).body(errorResponse)
    }
}
