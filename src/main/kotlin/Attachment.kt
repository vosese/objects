interface Attachment {
    val type: String
        get() = " "
}

data class Audio(
    val artistName: String,
    val title: String,
    val ownerId: Int
)

data class AudioAttachment(val audio: Audio) : Attachment {
    override val type: String = "Аудио"
}

data class Video(
    val title: String,
    val ownerId: Int,
    val duration: Int
)

data class VideoAttachment(val video: Video) : Attachment {
    override val type: String = "Видео"
}

data class Photo(
    val width: Int,
    val height: Int,
    val id: String
)

data class PhotoAttachment(val photo: Photo) : Attachment {
    override val type: String = "Фото"
}

data class Note(
    val title: String,
    val ownerId: Int
)

data class NoteAttachment(val note: Note) : Attachment {
    override val type: String = "Заметка"
}

data class Document(
    val number: Int,
    val title: String,
    val ownerId: Int
)

data class DocumentAttachment(val document: Document) : Attachment {
    override val type: String = "Документ"
}