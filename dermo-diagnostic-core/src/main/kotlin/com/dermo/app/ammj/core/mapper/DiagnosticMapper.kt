package com.dermo.app.ammj.core.mapper

import com.dermo.app.ammj.common.request.CreateAccountRequest
import com.dermo.app.ammj.common.response.CreateAccountResponse
import com.dermo.app.ammj.domain.entity.AccountEntity
import java.util.UUID

object DiagnosticMapper {

    fun getDiagnosticEntity(request: CreateAccountRequest) =
        AccountEntity(
            id = UUID.randomUUID(),
            correoElectronico = request.correoElectronico,
            contrasena = request.contrasena
        )

    fun createAccountResponse(entity: AccountEntity) =
        CreateAccountResponse(
            description = "Cuenta creada exitosamente",
            createdAt = entity.createdAt!!,
        )
}
