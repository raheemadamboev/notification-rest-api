package xyz.teamgravity

import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import xyz.teamgravity.data.remote.OneSignalServiceImpl
import xyz.teamgravity.plugins.configureMonitoring
import xyz.teamgravity.plugins.configureRouting
import xyz.teamgravity.plugins.configureSerialization

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {

    val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = KotlinxSerializer()

        }
    }

    configureMonitoring()
    configureRouting(OneSignalServiceImpl(client = client, apiKey = ApiKey.API_KEY))
    configureSerialization()
}
