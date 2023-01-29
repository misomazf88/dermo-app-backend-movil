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

    /*@Test
    fun `Create Nature`() {
        val url = NATURE
        val request = Generators.getNatureRequest()
        val response = Generators.getNatureResponse()
        Mockito.doReturn(response).`when`(natureService).create(request)
        val jsonRequest = request.objectToJson()
        mvc.perform(
            MockMvcRequestBuilders.post(url)
                .headers(HeadersUtils.resolverHeaders(HeadersUtils.getHeaders()))
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(
                MockMvcResultMatchers.jsonPath("$.nature").value("${response.nature}")
            )
            .andDo(MockMvcResultHandlers.print())
            .andReturn()
    }*/
}
