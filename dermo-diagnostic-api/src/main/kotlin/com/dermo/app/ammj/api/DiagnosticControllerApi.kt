package com.dermo.app.ammj.api

import com.dermo.app.ammj.common.request.CreateAccountRequest
import com.dermo.app.ammj.common.request.CreateDiagnosticRequest
import com.dermo.app.ammj.common.response.CreateAccountResponse
import org.springframework.http.ResponseEntity
import java.util.UUID

interface DiagnosticControllerApi {

    fun createAccount(
        dermoTraceabilityId: UUID,
        createAccountRequest: CreateAccountRequest
    ): ResponseEntity<CreateAccountResponse>

    fun login(
        dermoTraceabilityId: UUID,
        correoElectronico: String,
        contrasena: String
    ): ResponseEntity<CreateAccountResponse>

    fun createDiagnostic(
        dermoTraceabilityId: UUID,
        createAccountRequest: CreateDiagnosticRequest
    ): ResponseEntity<CreateAccountResponse>
}
