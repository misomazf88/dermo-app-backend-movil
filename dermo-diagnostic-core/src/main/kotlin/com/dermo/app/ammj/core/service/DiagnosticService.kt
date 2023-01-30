package com.dermo.app.ammj.core.service

import com.dermo.app.ammj.common.environment.VisionEnvironment.Companion.APP_NAME
import com.dermo.app.ammj.common.exception.toUnexpectedException
import com.dermo.app.ammj.common.request.CreateAccountRequest
import com.dermo.app.ammj.common.response.CreateAccountResponse
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
    fun createAccount(createAcccountRequest: CreateAccountRequest): CreateAccountResponse = try {
        logger.info(
            "--$APP_NAME --$CLASS:createAccount --correoElectronico[{}] --contrasena[{}]",
            createAcccountRequest.correoElectronico, createAcccountRequest.contrasena
        )

        val newAccount = repository.save(DiagnosticMapper.getDiagnosticEntity(createAcccountRequest))

        DiagnosticMapper.createAccountResponse(newAccount)
    } catch (ex: Exception) {
        logger.error(
            "--$APP_NAME --$CLASS:create --Request[{}] --Exception:[{}]",
            createAcccountRequest, ex.message
        )
        throw ex.toUnexpectedException()
    }
}
