package com.dermo.app.ammj.app.controller

import com.dermo.app.ammj.core.service.DiagnosticService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest(controllers = [DiagnosticController::class])
@OverrideAutoConfiguration(enabled = true)
class DiagnosticControllerTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @MockBean
    private lateinit var natureService: DiagnosticService

    fun `Iniciar sesion`() {
        val url = ""
    }
}
