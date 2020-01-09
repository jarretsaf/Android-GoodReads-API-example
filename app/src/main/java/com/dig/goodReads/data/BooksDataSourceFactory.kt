package com.dig.goodReads.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dig.goodReads.model.Book


class BooksDataSourceFactory(private val bookRepository: BookRepository) : DataSource.Factory<Int, Book>() {

    private val mutableLiveData: MutableLiveData<DataSource<Int, Book>> = MutableLiveData()
    var booksDataSource: BooksDataSource? = null

    var searchQuery : String = "Game"

    var dataSourceErrorListener : BooksDataSource.ErrorListener? = null

    override fun create(): DataSource<Int, Book> {
        booksDataSource = BooksDataSource(
            bookRepository,
            searchQuery,
            dataSourceErrorListener
        )
        mutableLiveData.postValue(booksDataSource)
        return booksDataSource!!
    }



//    fun getMutableLiveData():  MutableLiveData<DataSource<Int, Book>> {
//        return mutableLiveData
//    }
}