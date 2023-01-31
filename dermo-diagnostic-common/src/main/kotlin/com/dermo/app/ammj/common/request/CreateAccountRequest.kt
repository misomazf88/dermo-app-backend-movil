package com.dermo.app.ammj.common.request

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import javax.validation.constraints.NotNull

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CreateAccountRequest(
    @field:NotNull
    var correoElectronico: String,

    @field:NotNull
    var contrasena: String
)
