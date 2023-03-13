package com.dermo.app.ammj.common.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.sql.Timestamp
import java.time.LocalDateTime

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class GetUsersResponse(

    var usuarios: List<Users>? = emptyList(),

    var descripcion: String? = "",

    var createdAt: Timestamp? = Timestamp.valueOf(LocalDateTime.now()),

    var updatedAt: Timestamp? = Timestamp.valueOf(LocalDateTime.now())
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Users(
    var id: String? = "",

    var correoElectronico: String? = "",

    var nombre: String? = "",

    var edad: String? = "",

    var ciudad: String? = "",

    var createdAt: Timestamp? = Timestamp.valueOf(LocalDateTime.now())
)
