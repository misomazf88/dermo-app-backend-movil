package com.dermo.app.ammj.domain.utils

import com.dermo.app.ammj.domain.entity.AccountEntity
import java.util.UUID

object Generators {

    fun getDiagnosticEntity(): AccountEntity {
        var diagnosticEntity = AccountEntity(
            id = UUID.randomUUID(),
            diagnosticDescription = "Dermatitis",
            treatment = "Crema"
        )
        return diagnosticEntity
    }
}
