package xyz.teamgravity.data.remote

import xyz.teamgravity.data.remote.dto.NotificationDto

interface OneSignalService {

    companion object {
        const val ONE_SIGNAL_APP_ID = "fbdae96e-8ade-411c-807e-e182974c4d31"
        const val BASE_URL = "https://onesignal.com/api/v1/notifications"
    }

    suspend fun sendNotification(notification: NotificationDto): Boolean
}