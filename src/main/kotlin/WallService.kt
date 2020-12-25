class WallServiceCore {

    private var posts = emptyArray<Post>()

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

    fun getLastPost():Int = if (posts.isEmpty()) 0 else posts.last().id
}