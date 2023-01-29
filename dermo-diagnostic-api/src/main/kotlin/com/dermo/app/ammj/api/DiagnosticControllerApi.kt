package com.dermo.app.ammj.api

import com.dermo.app.ammj.common.request.CreateDiagnosticRequest
import com.dermo.app.ammj.common.response.CreateDiagnosticResponse
import java.util.UUID

interface DiagnosticControllerApi {

    fun createDiagnostic(
        dermoTraceabilityId: UUID,
        createDiagnosticRequest: CreateDiagnosticRequest
    ): CreateDiagnosticResponse
}
