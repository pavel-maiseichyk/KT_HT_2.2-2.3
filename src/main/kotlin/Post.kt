data class Post(
    val id: Int = 0,
    val ownerId: Int  = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    val text: String = "text",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val comments: Comments = Comments(),
    val copyright: String = "general Kenobi (c)",
    val likes: Likes = Likes(),
    val repost: Reposts = Reposts(),
    val views: Views = Views(),
    val postType: String = "post",
    val signerId: Int = 0,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavourite: Boolean = false,
    val postponedId: Int = 0,
)

data class Comments(
    val count: Int = 0, 
)
data class Views(
    val count: Int = 0
)

data class Likes(
    val count: Int = 0,
)

data class Reposts(
    val count: Int = 0,
)