package com.dermo.app.ammj.common.request

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.util.UUID
import javax.validation.constraints.NotNull

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CreateDiagnosticRequest(
    @field:NotNull
    var diagnosticId: UUID,

    @field:NotNull
    var createdAt: String,

    @field:NotNull
    var diagnosticDescription: String,

    @field:NotNull
    var treatment: String
)
