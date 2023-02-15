package com.dermo.app.ammj.core.mapper

import com.dermo.app.ammj.common.request.CreateAccountRequest
import com.dermo.app.ammj.common.response.CreateAccountResponse
import com.dermo.app.ammj.domain.entity.AccountEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.UUID

object DiagnosticMapper {

    fun getDiagnosticEntity(request: CreateAccountRequest) =
        AccountEntity(
            id = UUID.randomUUID(),
            correoElectronico = request.correoElectronico,
            contrasena = request.contrasena
        )

    fun createAccountResponse(entity: AccountEntity) =
        ResponseEntity(
            CreateAccountResponse(
                description = "Cuenta creada exitosamente",
                createdAt = entity.createdAt!!
            ),
            HttpStatus.CREATED
        )

    fun loginResponse(entity: AccountEntity) =
        ResponseEntity(
            CreateAccountResponse(
                description = "Inicio de sesion exitoso",
                createdAt = entity.createdAt!!
            ),
            HttpStatus.OK
        )

    fun loginPasswordErrorResponse() =
        ResponseEntity(
            CreateAccountResponse(
                description = "Credenciales invalidas"
            ),
            HttpStatus.UNAUTHORIZED
        )

    fun loginErrorResponse() =
        ResponseEntity(
            CreateAccountResponse(
                description = "La cuenta no existe"
            ),
            HttpStatus.NOT_FOUND
        )

    fun createAccountResponseCorreoExiste() =
        ResponseEntity(
            CreateAccountResponse(
                description = "El correo ingresado ya esta registrado"
            ),
            HttpStatus.BAD_REQUEST
        )
}
