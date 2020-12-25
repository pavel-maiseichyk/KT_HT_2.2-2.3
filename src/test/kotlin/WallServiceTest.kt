import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

class WallServiceCoreTest {

    @Test
    fun add() {
        val service = WallServiceCore()
        val expected = service.getLastPost() + 1
        service.add(post = Post())
        assertEquals(service.getLastPost(), expected)
    }

    @Test
    fun updateExisting() {
        val service = WallServiceCore()
        service.add(post = Post(text = "первый пошёл!"))
        service.add(post = Post(text = "второй пошёл!"))
        service.add(post = Post(text = "третий пошёл!"))

        val updatePost = Post(id = 2, text = "второй обновлён!")
        val result = service.update(updatePost)
        assertTrue(result)
    }

    @Test
    fun updateNonExisting() {
        val service = WallServiceCore()
        service.add(post = Post(text = "первый пошёл!"))
        service.add(post = Post(text = "второй пошёл!"))
        service.add(post = Post(text = "третий пошёл!"))

        val updatePost = Post(id = 7, text = "второй обновлён!")
        val result = service.update(updatePost)
        assertTrue(!result)
    }
}