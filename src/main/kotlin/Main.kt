data class Post(
    val id: Int,
    val authorId: Int,
    val authorName: String,
    val content: String,
    val published: Long,
    val likes: Int,
    val replyPostId: Int, //Идентификатор записи, в ответ на которую была оставлена текущая.
    val canPin: Boolean, //Информация о том, может ли текущий пользователь закрепить запись (true — может, false — не может).
    val canDelete: Boolean, //Информация о том, может ли текущий пользователь удалить запись (true — может, false — не может).
    val isFavorite: Boolean //true, если объект добавлен в закладки у текущего пользователя
)

class Like(
    val count: Int = 5165,
    val userLikes: Boolean = true,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)

object WallService {

    private var posts = emptyArray<Post>()
    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun likeById(id: Int) {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(likes = post.likes + 1)
            }
        }
    }
}

object Likes {
    fun add(like: Like): Like {
        return like
    }
}

fun main() {
    val post = Post(1, 1, "author", "content", 0, 0, 5, true, true, false)
    val liked = post.copy(likes = post.likes + 1)
    val (id, authorId, _, content) = post
    println(liked.likes)
    println("$id, $authorId, $content")

    val like = Like()
    println(like.count)


}