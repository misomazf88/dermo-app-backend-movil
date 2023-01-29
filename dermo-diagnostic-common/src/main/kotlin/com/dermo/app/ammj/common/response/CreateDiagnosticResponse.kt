package com.dermo.app.ammj.common.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.sql.Timestamp
import java.util.UUID
import javax.validation.constraints.NotNull

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CreateDiagnosticResponse(
    @field:NotNull
    var diagnosticId: UUID,

    @field:NotNull
    var createdAt: Timestamp,
)
