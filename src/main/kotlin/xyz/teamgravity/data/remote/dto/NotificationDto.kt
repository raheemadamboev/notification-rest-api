package xyz.teamgravity.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NotificationDto(
    @SerialName("included_segments") val includedSegments: List<String>,
    val contents: NotificationMessageDto,
    val headings: NotificationMessageDto,
    @SerialName("app_id") val appId: String
)
