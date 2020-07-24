package com.ramzan.bookSearch;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;


import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ramzan.bookSearch.models.Book;
import com.ramzan.bookSearch.models.VolumeInfo;
import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    public static List<Book> bookList;
    private static OnItemClickListener mListener;

    private static final String TAG = "myLog";

    public interface OnItemClickListener {
        void onItemClick(Book book);
    }

    public interface OnItemClickListenerTwo{
        void onItemClick(VolumeInfo volumeInfo);
    }

    public RecycleViewAdapter(OnItemClickListener listener) {
        mListener = listener;
        bookList = new ArrayList<>();

    }

    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new ViewHolder(view);
    }




    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG,"PROVERKA");
        try {
            Book book = bookList.get(position);
            holder.bookTitleTextView.setText(book.volumeInfo.title);
            holder.bookAuthorTextView.setText("Authors: " + book.volumeInfo.authors.toString());
            holder.bookPublisherTextView.setText("publication date: " + book.volumeInfo.publishedDate);
            if(book.volumeInfo.averageRating != null) {
                holder.bookAverageRating.setText(" rating: " + book.volumeInfo.averageRating);
            }
            else holder.bookAverageRating.setText("N/A");
            holder.bookPageCount.setText(book.volumeInfo.pageCount + " page");
            Glide.with(holder.bookThumbnailImageView.getContext()).load(book.volumeInfo.imageLinks.smallThumbnail).into(holder.bookThumbnailImageView);

            holder.bind(bookList.get(position), mListener);

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView bookThumbnailImageView;
        TextView bookTitleTextView;
        TextView bookAuthorTextView;
        TextView bookPublisherTextView;
        TextView bookPageCount;
        TextView bookAverageRating;

        public ViewHolder(View itemView) {

            super(itemView);
            Log.d(TAG, "установка");
            bookThumbnailImageView = itemView.findViewById(R.id.cover_book_image_view);
            bookTitleTextView = itemView.findViewById(R.id.book_title_text_view);
            bookAuthorTextView = itemView.findViewById(R.id.book_author_text_view);
            bookPublisherTextView = itemView.findViewById(R.id.book_date_text_view);
            bookPageCount = itemView.findViewById(R.id.book_number_pages_text_view);
            bookAverageRating = itemView.findViewById(R.id.book_rating_text_view);

        }

        public void bind(final Book book, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(book);
                }
            });
        }
    }

    public void clear() {
        bookList.clear();
        notifyDataSetChanged();

    }

    public void setData(List<Book> books) {
        bookList.addAll(books);
        notifyDataSetChanged();
    }

}
