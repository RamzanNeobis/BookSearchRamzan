package com.ramzan.bookSearch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.ramzan.bookSearch.models.Book;
import com.ramzan.bookSearch.models.ResponseBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {


    private Button searchButton;
    private RecyclerView recyclerView;
    private RecycleViewAdapter recycleViewAdapter;
    private static final String TAG = "myLog";


    private final String langRestrict = "en";
    private final int maxResults = 40;
    private final String printType = "books";
    private final String key = "AIzaSyAyHcoY2k3k0vcKe0fkFqxPF4EqNHsI26Y";
    APIDeclaration service = RetrofitInstance.getRetrofitInstance().create(APIDeclaration.class);
    RecycleViewAdapter.OnItemClickListener clickListener = new RecycleViewAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(Book book) {
            String url = book.volumeInfo.getPreviewLink();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();

        String textSearch = intent.getStringExtra("name");


        searchButton = findViewById(R.id.button_search);
        recyclerView = findViewById(R.id.rv_book_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recycleViewAdapter = new RecycleViewAdapter(clickListener);
        Log.d(TAG, "установка");
        recyclerView.setAdapter(recycleViewAdapter);
        Log.d(TAG, "Смотрим загрузку");
        service.getBooks(langRestrict, maxResults, printType, key, textSearch)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                        if (response.body() != null) {
                            recycleViewAdapter.setData(response.body().bookList);
                        }


                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e(MainActivity.class.getSimpleName(), "onFailure");
                        t.getMessage();
                    }
                });
    }
}


