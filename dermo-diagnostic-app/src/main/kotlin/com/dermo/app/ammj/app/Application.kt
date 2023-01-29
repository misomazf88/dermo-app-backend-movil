package com.dermo.app.ammj.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(
    "com.dermo.app.ammj"
)
class Application

fun main(args: Array<String>) {
    val app = SpringApplication(Application::class.java)
    app.run(*args)
}
