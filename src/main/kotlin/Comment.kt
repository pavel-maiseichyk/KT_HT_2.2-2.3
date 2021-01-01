data class Comment(
        val ownerId: Int = 0,
        val postId: Int = 0,
        val fromGroup: Int = 0,
        val message: String = "null",
        val replyToComment: Int = 0,
        val attachments: Array<CommentAttachments>? = null,
        val stickerId: Int = 0,
        val guid: Int = 0
)

data class CommentAttachments(
        val type: String,
        val ownerId: Int,
        val mediaId: Int
)