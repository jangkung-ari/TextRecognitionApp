package com.arimukti.myhealth.data.db

import androidx.room.*
import com.arimukti.myhealth.data.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Query("select * from articles")
    fun getAllArticles(): Flow<List<Article>>

    @Delete
    suspend fun delete(article: Article)

}