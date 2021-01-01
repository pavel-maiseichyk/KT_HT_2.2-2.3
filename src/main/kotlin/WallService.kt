import java.lang.RuntimeException

object WallService {

    var posts = emptyArray<Post>()
    var comments = emptyArray<Comment>()

    class PostNotFoundException(message: String) : RuntimeException(message)

    fun add(post: Post): Post {
        posts += if (posts.isEmpty()) post.copy(id = 1) else post.copy(id = posts.last().id + 1)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, currentPost) in posts.withIndex()) {
            if (post.id == currentPost.id) {
                posts[index] = post.copy(ownerId = currentPost.id, date = currentPost.id)
                return true
            }
        }
        return false
    }

    fun getLastPost(): Int = if (posts.isEmpty()) 0 else posts.last().id

    fun createComment(comment: Comment) {
        var isAdded = false
        for (post in posts)
            if (post.id == comment.postId) {
                comments += comment
                isAdded = true
            }
        if (!isAdded) throw PostNotFoundException("well, no post there, fellas")
    }
}