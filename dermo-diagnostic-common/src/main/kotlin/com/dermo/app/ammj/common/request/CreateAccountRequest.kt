package com.dermo.app.ammj.common.request

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import javax.validation.constraints.NotNull

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CreateAccountRequest(
    @field:NotNull(message = "El campo correoElectronico es obligatorio")
    var correoElectronico: String,

    @field:NotNull(message = "El campo contrasena es obligatorio")
    var contrasena: String
)
