package com.dermo.app.ammj.domain.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "diagnostic")
data class DiagnosticEntity(

    @Id
    var id: UUID? = null,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD HH:MM:SS.SSS")
    var createdAt: Timestamp? = Timestamp.valueOf(LocalDateTime.now()),

    var diagnosticDescription: String? = null,

    var treatment: String? = null
)
