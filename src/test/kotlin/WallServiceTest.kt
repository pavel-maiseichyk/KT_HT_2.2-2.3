import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

class WallServiceTest {

    @Test
    fun add() {
        val expected = WallService.getLastPost() + 1
        WallService.add(post = Post())
        assertEquals(WallService.getLastPost(), expected)
    }

    @Test
    fun updateExisting() {
        WallService.add(post = Post(text = "первый пошёл!"))
        WallService.add(post = Post(text = "второй пошёл!"))
        WallService.add(post = Post(text = "третий пошёл!"))

        val updatePost = Post(id = 2, text = "второй обновлён!")
        val result = WallService.update(updatePost)
        assertTrue(result)
    }

    @Test
    fun updateNonExisting() {
        WallService.add(post = Post(text = "первый пошёл!"))
        WallService.add(post = Post(text = "второй пошёл!"))
        WallService.add(post = Post(text = "третий пошёл!"))

        val updatePost = Post(id = 7, text = "второй обновлён!")
        val result = WallService.update(updatePost)
        assertTrue(!result)
    }

    @Test
    fun shouldNotThrowPostNotFoundException() {
        val newComments = WallService.comments
        WallService.posts += Post(id = 11)
        val comment = Comment(postId = 11)
        WallService.createComment(comment)
        assertTrue(!WallService.comments.contentEquals(newComments))
    }

    @Test(expected = WallService.PostNotFoundException::class)
    fun shouldThrowPostNotFoundException() {
        WallService.posts += Post(id = 9)
        val comment = Comment(postId = 789)
        WallService.createComment(comment)
    }
}