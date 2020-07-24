package com.ramzan.bookSearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivitySearch extends AppCompatActivity implements View.OnClickListener{

    EditText editText;
    Button button;
    public Button back;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editText = (EditText) findViewById(R.id.book_input_search_editText);
        button = (Button) findViewById(R.id.button_search);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", editText.getText().toString());
        startActivity(intent);
    }
}
