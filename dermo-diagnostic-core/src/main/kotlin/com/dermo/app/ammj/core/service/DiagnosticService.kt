package com.dermo.app.ammj.core.service

import com.dermo.app.ammj.common.environment.VisionEnvironment.Companion.APP_NAME
import com.dermo.app.ammj.common.exception.toUnexpectedException
import com.dermo.app.ammj.common.request.CreateAccountRequest
import com.dermo.app.ammj.common.request.CreateDiagnosticRequest
import com.dermo.app.ammj.common.response.CreateAccountResponse
import com.dermo.app.ammj.core.mapper.DiagnosticMapper
import com.dermo.app.ammj.domain.repository.AccountRepository
import com.dermo.app.ammj.domain.repository.DiagnosticRepository
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class DiagnosticService(
    private val accountRepository: AccountRepository,
    private val diagnosticRepository: DiagnosticRepository
) {

    private var logger = LoggerFactory.getLogger(DiagnosticService::class.java)
    private val CLASS = DiagnosticService::class.simpleName

    @Transactional
    fun createAccount(createAcccountRequest: CreateAccountRequest): ResponseEntity<CreateAccountResponse> = try {
        logger.info(
            "--$APP_NAME --$CLASS:createAccount --correoElectronico[{}] --contrasena[{}]",
            createAcccountRequest.correoElectronico, createAcccountRequest.contrasena
        )

        if (accountRepository.findByCorreoElectronico(createAcccountRequest.correoElectronico.toString()).isPresent) {
            DiagnosticMapper.createAccountResponseCorreoExiste()
        } else if (accountRepository.findByCorreoElectronico(createAcccountRequest.correoElectronico.toString()).isPresent && accountRepository.findByCorreoElectronico(
                createAcccountRequest.correoElectronico.toString()
            ).get().contrasena.equals(createAcccountRequest.contrasena)
        ) {
            DiagnosticMapper.createAccountResponseCorreoExiste()
        } else {
            val newAccount = accountRepository.save(DiagnosticMapper.getAccountEntity(createAcccountRequest))
            DiagnosticMapper.createAccountResponse(newAccount)
        }
    } catch (ex: Exception) {
        logger.error(
            "--$APP_NAME --$CLASS:create --Request[{}] --Exception:[{}]",
            createAcccountRequest, ex.message
        )
        throw ex.toUnexpectedException()
    }

    fun login(createAcccountRequest: CreateAccountRequest): ResponseEntity<CreateAccountResponse> = try {
        logger.info(
            "--$APP_NAME --$CLASS:login --correoElectronico[{}] --contrasena[{}]",
            createAcccountRequest.correoElectronico, createAcccountRequest.contrasena
        )
        val accountDb = accountRepository.findByCorreoElectronico(createAcccountRequest.correoElectronico!!)
        if (accountDb.isPresent && accountDb.get().contrasena.equals(createAcccountRequest.contrasena)) {
            DiagnosticMapper.loginResponse(accountDb.get())
        } else if (accountDb.isPresent && !accountDb.get().contrasena.equals(createAcccountRequest.contrasena)) {
            DiagnosticMapper.loginPasswordErrorResponse()
        } else {
            DiagnosticMapper.loginErrorResponse()
        }
    } catch (ex: Exception) {
        logger.error(
            "--$APP_NAME --$CLASS:create --Request[{}] --Exception:[{}]",
            createAcccountRequest, ex.message
        )
        throw ex.toUnexpectedException()
    }

    @Transactional
    fun createDiagnostic(createDiagnosticRequest: CreateDiagnosticRequest): ResponseEntity<CreateAccountResponse> = try {
        logger.info(
            "--$APP_NAME --$CLASS:createDiagnostic --nombre[{}] --edad[{}] --ciudad[{}] --tipo de piel[{}] --imagen[{}]",
            createDiagnosticRequest.nombre, createDiagnosticRequest.edad, createDiagnosticRequest.ciudad, createDiagnosticRequest.tipoDePiel, createDiagnosticRequest.foto
        )
        val newAccount = diagnosticRepository.save(DiagnosticMapper.getDiagnosticEntity(createDiagnosticRequest))
        DiagnosticMapper.createDiagnosticResponse(newAccount)
    } catch (ex: Exception) {
        logger.error(
            "--$APP_NAME --$CLASS:createDiagnostic --Request[{}] --Exception:[{}]",
            createDiagnosticRequest, ex.message
        )
        throw ex.toUnexpectedException()
    }
}
