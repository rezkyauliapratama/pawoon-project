package android.rezkyauliapratama.com.pawoonprojecttodolist.data.database.entity

data class TodoSchema(
    val id: Int,
    val userId: Int,
    val title: String,
    val completed: Int
){
    companion object {
        const val TABLE_TODO: String = "TABLE_TODO"
        const val ID: String = "ID"
        const val USER_ID: String = "USER_ID"
        const val TITLE: String = "TITLE"
        const val COMPLETED: String = "COMPLETED"

    }
}