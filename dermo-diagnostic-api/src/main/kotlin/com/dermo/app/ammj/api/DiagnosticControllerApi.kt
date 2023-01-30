package com.dermo.app.ammj.api

import com.dermo.app.ammj.common.request.CreateAccountRequest
import com.dermo.app.ammj.common.response.CreateAccountResponse
import java.util.UUID

interface DiagnosticControllerApi {

    fun createDiagnostic(
        dermoTraceabilityId: UUID,
        createDiagnosticRequest: CreateAccountRequest
    ): CreateAccountResponse
}
