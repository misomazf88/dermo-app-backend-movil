package com.dermo.app.ammj.core.util

import com.dermo.app.ammj.common.request.CreateDiagnosticRequest
import com.dermo.app.ammj.domain.entity.DiagnosticEntity
import java.util.UUID

object Generators {

    fun getDiagnosticRequest() =
        CreateDiagnosticRequest(
            diagnosticId = UUID.randomUUID(),
            createdAt = "",
            diagnosticDescription = "Dermatitis",
            treatment = "Crema"
        )

    fun getDiagnosticEntity() =
        DiagnosticEntity(
            id = UUID.randomUUID(),
            diagnosticDescription = "Dermatitis",
            treatment = "Crema"
        )

    fun getDiagnosticEntities(): List<DiagnosticEntity> {
        var listOfDiagnosticEntity = listOf<DiagnosticEntity>()

        var diagnosticEntity = DiagnosticEntity(
            id = UUID.randomUUID(),
            diagnosticDescription = "Dermatitis",
            treatment = "Crema"
        )
        listOfDiagnosticEntity += diagnosticEntity

        return listOfDiagnosticEntity
    }
}
