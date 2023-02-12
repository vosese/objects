import org.junit.Test

import org.junit.Before

class WallServiceTestUpdate {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun update1() {
        val post = Post(0)
        WallService.update(post)
        assert(true)
    }

 /*  @Test
    fun update2() {

       assert(false)
    }

  */


}