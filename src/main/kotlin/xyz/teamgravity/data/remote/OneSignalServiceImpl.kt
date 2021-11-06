package xyz.teamgravity.data.remote

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import xyz.teamgravity.data.remote.dto.NotificationDto

class OneSignalServiceImpl(
    private val client: HttpClient,
    private val apiKey: String
) : OneSignalService {

    override suspend fun sendNotification(notification: NotificationDto): Boolean {
        return try {
            client.post<String> {
                url(OneSignalService.BASE_URL)
                contentType(ContentType.Application.Json)
                header("Authorization", "Basic $apiKey")
                body = notification
            }
            true
        }catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}