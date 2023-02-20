package com.dermo.app.ammj.domain.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema = "dermoapp_patient", name = "diagnostic")
data class DiagnosticEntity(

    @Id
    var id: UUID? = null,

    @Column
    var nombre: String? = null,

    @Column
    var edad: String? = null,

    @Column
    var ciudad: String? = null,

    @Column
    var tipoDePiel: String? = null,

    @Column
    var foto: String? = null,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD HH:MM:SS.SSS")
    var createdAt: Timestamp? = Timestamp.valueOf(LocalDateTime.now()),

)
