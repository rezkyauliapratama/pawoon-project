package android.rezkyauliapratama.com.pawoonprojecttodolist.di.application

import android.content.Context
import android.rezkyauliapratama.com.pawoonprojecttodolist.data.database.MyDatabaseOpenHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Rezky Aulia Pratama on 25/8/18.
 */
@Module
class DatabaseModule{


    @Provides
    @DatabaseInfo
    fun provideDatabaseName():String{
        return "pawoon-project.db"
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseVersion():Int{
        return 1
    }

    @Singleton
    @Provides
    internal fun provideDatabaseHelper(@ApplicationContext context: Context, @DatabaseInfo name:String, @DatabaseInfo version: Int): MyDatabaseOpenHelper {
        return MyDatabaseOpenHelper(context,name,version)
    }
}