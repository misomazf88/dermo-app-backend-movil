package com.dermo.app.ammj.app.controller

import com.dermo.app.ammj.app.utils.Generators
import com.dermo.app.ammj.common.request.CreateAccountRequest
import com.dermo.app.ammj.common.response.CreateAccountResponse
import com.dermo.app.ammj.common.route.Route
import com.dermo.app.ammj.core.service.DiagnosticService
import com.google.gson.Gson
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.sql.Timestamp
import java.time.LocalDateTime

@WebMvcTest(controllers = [DiagnosticController::class])
@OverrideAutoConfiguration(enabled = true)
class DiagnosticControllerTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @MockBean
    private lateinit var diagnosticService: DiagnosticService

    @Test
    fun `Crear cuenta Exitosamente`() {
        val accountRequest = CreateAccountRequest(
            correoElectronico = "mazf@gmail.com",
            contrasena = "123"
        )

        val accountResponse = CreateAccountResponse(
            description = "Cuenta creada exitosamente",
            createdAt = Timestamp.valueOf(LocalDateTime.now())
        )

        Mockito.doReturn(accountResponse).`when`(diagnosticService).createAccount(accountRequest)

        val gson = Gson()

        val jsonRequest = gson.toJson(accountRequest)

        val jsonResponse = gson.toJson(accountResponse)

        mvc.perform(
            MockMvcRequestBuilders.post(Route.Diagnostic.ACCOUNT)
                .headers(Generators.getAccountHeaders())
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
            // .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString(jsonResponse)))
            .andDo(MockMvcResultHandlers.print())
            .andReturn()
    }

    @Test
    fun `Crear cuenta Bad Request`() {
        val accountRequest = CreateAccountRequest(
            correoElectronico = "mazf@gmail.com",
            contrasena = "123"
        )

        val accountResponse = CreateAccountResponse(
            description = "Cuenta creada exitosamente",
            createdAt = Timestamp.valueOf(LocalDateTime.now())
        )

        val gson = Gson()

        val jsonRequest = gson.toJson(accountRequest)

        mvc.perform(
            MockMvcRequestBuilders.post(Route.Diagnostic.ACCOUNT)
                .headers(Generators.getAccountHeaders())
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
            .andDo(MockMvcResultHandlers.print())
            .andReturn()
    }
}
