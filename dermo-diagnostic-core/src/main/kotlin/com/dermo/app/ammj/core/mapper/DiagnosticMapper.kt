package com.dermo.app.ammj.core.mapper

import com.dermo.app.ammj.common.request.CreateDiagnosticRequest
import com.dermo.app.ammj.common.response.CreateDiagnosticResponse
import com.dermo.app.ammj.domain.entity.DiagnosticEntity
import java.sql.Timestamp

object DiagnosticMapper {

    fun getDiagnosticEntity(request: CreateDiagnosticRequest) =
        DiagnosticEntity(
            id = request.diagnosticId,
            createdAt = Timestamp.valueOf(request.createdAt),
            diagnosticDescription = request.diagnosticDescription,
            treatment = request.treatment
        )

    fun getNatureResponse(entity: DiagnosticEntity) =
        CreateDiagnosticResponse(
            diagnosticId = entity.id!!,
            createdAt = entity.createdAt!!,
        )
}
