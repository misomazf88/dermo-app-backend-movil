package com.dermo.app.ammj.common.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.sql.Timestamp
import javax.validation.constraints.NotNull

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CreateAccountResponse(
    @field:NotNull
    var description: String,

    @field:NotNull
    var createdAt: Timestamp
)
