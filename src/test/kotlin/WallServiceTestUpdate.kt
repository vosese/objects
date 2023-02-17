import org.junit.Test

import org.junit.Before
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class WallServiceTestUpdate {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun update1() {
        val post = WallService.add(Post(1, original = null))
        val result = WallService.update(post)
        assertEquals(true, result)
    }

    @Test
       fun update2() {
        val post = Post(3, original = null)
        val result = WallService.update(post)
        assertEquals(false, result)
       }



}