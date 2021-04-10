package ca.six.demo.cleanviper.entity

data class BookDetail(var chapters: List<BookChapter>)

data class BookChapter(var name: String, var audio: String, var notebook: String)
