package com.dig.goodreads.components.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.dig.goodreads.R
import com.dig.goodreads.model.Book
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_book_list_item.view.*


class BookListItem : ConstraintLayout, View.OnClickListener {

    lateinit var book : Book

    var listener : ClickDelegate? = null

    constructor(context: Context?) : super(context){
        initView()
    }


    constructor(context: Context?, book : Book) : this(context){
        initData(book)
    }

    fun initData(book : Book){
        this.book = book
        bookItemName.setText(book.name)
        Picasso.get().load(book.imageUrl).into(bookItemImage);
    }

    private fun initView() {
        LayoutInflater.from(context).inflate(R.layout.view_book_list_item, this, true);
    }



    override fun onClick(v: View?) {
        listener?.OnBookListItemClicked(book)
    }
    //TODO: Should Be send back to caller
//    override fun onClick(v: View?) {
//        val bookDetailIntent = Intent(context, BookDetailActivity::class.java)
//        bookDetailIntent.putExtra("book", book) //Optional parameters
//        context.startActivity(bookDetailIntent)
//    }

    fun registerListner(clickDelegate: ClickDelegate){
        this.listener = clickDelegate
    }

    interface ClickDelegate{
        fun OnBookListItemClicked(book : Book)
    }


}