package com.dermo.app.ammj.app.controller

import com.dermo.app.ammj.api.DiagnosticControllerApi
import com.dermo.app.ammj.common.constant.Constant.Trace.DERMO_TRACEABILITY_ID
import com.dermo.app.ammj.common.request.CreateAccountRequest
import com.dermo.app.ammj.common.route.Route
import com.dermo.app.ammj.core.service.DiagnosticService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.validation.Valid

@RestController
@RequestMapping(produces = [(MediaType.APPLICATION_JSON_VALUE)])
class DiagnosticController(
    private val accountService: DiagnosticService
) : DiagnosticControllerApi {

    @PostMapping(Route.Diagnostic.ACCOUNT)
    override fun createAccount(
        @RequestHeader(DERMO_TRACEABILITY_ID) dermoTraceabilityId: UUID,
        @RequestBody @Valid createAccountRequest: CreateAccountRequest
    ) = when (accountService.createAccount(createAccountRequest).description) {
        "Cuenta creada exitosamente" -> ResponseEntity(accountService.createAccount(createAccountRequest), HttpStatus.CREATED)
        else -> {
            ResponseEntity(accountService.createAccount(createAccountRequest), HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping(Route.Diagnostic.ACCOUNT_LOGIN)
    override fun login(
        @RequestHeader(DERMO_TRACEABILITY_ID) dermoTraceabilityId: UUID,
        @RequestParam @Valid correoElectronico: String,
        @RequestParam @Valid contrasena: String,
    ) = when (accountService.login(correoElectronico, contrasena).description) {
        "Inicio de sesion exitoso" -> ResponseEntity(accountService.login(correoElectronico, contrasena), HttpStatus.OK)
        else -> {
            ResponseEntity(accountService.login(correoElectronico, contrasena), HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping(Route.Diagnostic.DIAGNOSTIC_CREATE)
    override fun createDiagnostic(
        @RequestHeader(DERMO_TRACEABILITY_ID) dermoTraceabilityId: UUID,
        @RequestBody @Valid createAccountRequest: CreateAccountRequest
    ) = when (accountService.createAccount(createAccountRequest).description) {
        "Inicio de sesion exitoso" -> ResponseEntity(accountService.createDiagnostic(createAccountRequest), HttpStatus.CREATED)
        else -> {
            ResponseEntity(accountService.createDiagnostic(createAccountRequest), HttpStatus.BAD_REQUEST)
        }
    }
}
