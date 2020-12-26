package attachments

sealed class Attachments {
    abstract val type: String
}

data class VideoAttachments(override val type: String = "video", val video: Video): Attachments()

data class AudioAttachments(override val type: String = "audio", val audio: Audio): Attachments()

data class PhotoAttachments(override val type: String = "photo", val photo: Photo): Attachments()

data class DocAttachments(override val type: String = "doc", val doc: Doc): Attachments()

data class StickerAttachments(override val type: String = "sticker", val sticker: Sticker): Attachments()