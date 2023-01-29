package com.dermo.app.ammj.domain.utils

import com.dermo.app.ammj.domain.entity.DiagnosticEntity
import java.util.UUID

object Generators {

    fun getDiagnosticEntity(): DiagnosticEntity {
        var diagnosticEntity = DiagnosticEntity(
            id = UUID.randomUUID(),
            diagnosticDescription = "Dermatitis",
            treatment = "Crema"
        )
        return diagnosticEntity
    }
}
