data class Post(
    val id: Int,
    val authorId: Int = 86464,
    val authorName: String = "Petya",
    val content: String = "Picture and photo",
    val published: Long = 94949,
    val likes: Int = 0,
    val replyPostId: Int = 1,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val isFavorite: Boolean = true,
    val original: Post?,
    val like: Like = Like(
        0,
        true,
        true,
        true
    ),
    var attachmentArray: Array<Attachment> = emptyArray()
)


data class Like(
    val count: Int,
    val userLikes: Boolean = true,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)

data class Comment(
    val id: Int,
    val fromId: Int,
    val date: String,
    val text: String,
)

class PostNotFoundException(message: String) : RuntimeException(message)

object WallService {

    private var posts = emptyArray<Post>()
    private var lastId = 0
    var comments = emptyArray<Comment>()
    fun add(post: Post): Post {
        posts += post.copy(id = ++lastId, like = post.like.copy())
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy(like = newPost.like.copy())
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        lastId = 0

        val result = lastId > 0
    }

    fun printPosts() {
        for (post in posts) {
            println(post)
        }
        println()
    }


    fun createComment(postId: Int, comment: Comment): Comment {
        for ((index, post) in posts.withIndex()) {
            if (postId == post.id) {
                comments += comment
                return comments.last()
            }
        }
        return throw PostNotFoundException("В ID $postId нет такого поста")
    }

}


fun main() {
    val post = Post(1, original = null)
    val repost = Post(2, original = post)
    val comment = Comment(1, 5555, "1 апреля", "Ля ля ля")
    WallService.add(post)
    WallService.update(post)
    WallService.printPosts()
    WallService.createComment(1, comment)
    println(WallService.comments.last())
}