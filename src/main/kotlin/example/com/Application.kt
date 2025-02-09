package example.com

import example.com.core.DatabaseFactory
import example.com.di.configureDI
import example.com.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8081, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    DatabaseFactory.init()
    configureDI()
    configureSecurity()
    configureSwagger()
    configureRouting()
}
