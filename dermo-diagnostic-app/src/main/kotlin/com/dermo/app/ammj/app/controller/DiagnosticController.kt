package com.dermo.app.ammj.app.controller

import com.dermo.app.ammj.api.DiagnosticControllerApi
import com.dermo.app.ammj.common.constant.Constant.Trace.DERMO_TRACEABILITY_ID
import com.dermo.app.ammj.common.request.CreateAccountRequest
import com.dermo.app.ammj.common.route.Route
import com.dermo.app.ammj.core.service.DiagnosticService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.validation.Valid

@RestController
@RequestMapping(produces = [(MediaType.APPLICATION_JSON_VALUE)])
class DiagnosticController(
    private val accountService: DiagnosticService
) : DiagnosticControllerApi {

    @PostMapping(Route.Diagnostic.ACCOUNT)
    override fun createDiagnostic(
        @RequestHeader(DERMO_TRACEABILITY_ID) dermoTraceabilityId: UUID,
        @RequestBody @Valid AccountReques: CreateAccountRequest
    ) = accountService.createAccount(AccountReques)
}
