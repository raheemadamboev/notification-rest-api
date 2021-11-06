package xyz.teamgravity.plugins

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import xyz.teamgravity.data.remote.OneSignalService
import xyz.teamgravity.data.remote.dto.NotificationDto
import xyz.teamgravity.data.remote.dto.NotificationMessageDto

fun Application.configureRouting(service: OneSignalService) {

    routing {
        get("/sendNotification") {
            val title = call.parameters["title"] ?: "title"
            val description = call.parameters["description"] ?: "description"

            val successful = service.sendNotification(
                NotificationDto(
                    includedSegments = listOf("All"),
                    headings = NotificationMessageDto(en = title),
                    contents = NotificationMessageDto(en = description),
                    appId = OneSignalService.ONE_SIGNAL_APP_ID
                )
            )

            if (successful) {
                call.respond(HttpStatusCode.OK)
            } else {
                call.respond(HttpStatusCode.InternalServerError)
            }
        }
    }
}
