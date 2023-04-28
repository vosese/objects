import org.junit.Test
import org.junit.Assert.*
class WallServiceTestAddComment {

    @Test
    fun createComment(){
        val service = WallService
        val post1 = Post(0,621,"Mike","Earth",513165, 28, 5, true, true, true, original = null, Like(1, true, true,true))

        service.add(post1)
        val comment = Comment(1,944, "2 апреля", "Парам-пам-пам" )
        val result = service.createComment(1, comment)
        assertNotNull(result)
    }
    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val service = WallService
        val post1 = Post(0,621,"Mike","Earth",513165, 28, 5, true, true, true, original = null, Like(1, true, true,true))
        service.add(post1)
        val comment = Comment(99, 15, "5 апреля", "Трололо")
        val result = service.createComment(55, comment)
    }

}