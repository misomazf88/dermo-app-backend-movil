package com.dermo.app.ammj.core.service

import com.dermo.app.ammj.common.environment.VisionEnvironment.Companion.APP_NAME
import com.dermo.app.ammj.common.exception.toUnexpectedException
import com.dermo.app.ammj.common.request.CreateDiagnosticRequest
import com.dermo.app.ammj.common.response.CreateDiagnosticResponse
import com.dermo.app.ammj.core.mapper.DiagnosticMapper
import com.dermo.app.ammj.domain.repository.DiagnosticRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class DiagnosticService(
    private val repository: DiagnosticRepository
) {

    private var logger = LoggerFactory.getLogger(DiagnosticService::class.java)
    private val CLASS = DiagnosticService::class.simpleName

    @Transactional
    fun createDiagnostic(createDiagnosticRequest: CreateDiagnosticRequest): CreateDiagnosticResponse = try {
        logger.info(
            "--$APP_NAME --$CLASS:createDiagnostic --diagnosticId[{}] --createdAt[{}] --diagnosticDescription[{}] --diagnostic_description[{}]",
            createDiagnosticRequest.diagnosticId, createDiagnosticRequest.createdAt, createDiagnosticRequest.diagnosticDescription, createDiagnosticRequest.treatment
        )

        val newDiagnostic = repository.save(DiagnosticMapper.getDiagnosticEntity(createDiagnosticRequest))

        DiagnosticMapper.getNatureResponse(newDiagnostic)
    } catch (ex: Exception) {
        logger.error(
            "--$APP_NAME --$CLASS:create --Request[{}] --Exception:[{}]",
            createDiagnosticRequest, ex.message
        )
        throw ex.toUnexpectedException()
    }
}
