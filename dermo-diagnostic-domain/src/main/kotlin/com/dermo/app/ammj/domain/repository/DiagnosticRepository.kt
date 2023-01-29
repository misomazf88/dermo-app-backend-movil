package com.dermo.app.ammj.domain.repository

import com.dermo.app.ammj.domain.entity.DiagnosticEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DiagnosticRepository : JpaRepository<DiagnosticEntity, Long>
