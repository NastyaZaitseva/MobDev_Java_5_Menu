package com.example.guess_the_number;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Guess_the_number extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean game_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_number);

        tvInfo=findViewById(R.id.textView);
        etInput=findViewById(R.id.editText);
        bControl=findViewById(R.id.button);


        guess= (int) (Math.random()*100);
        game_finish=false;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        // TODO Auto-generated method stub

        switch (id){
            case R.id.close_game:
                finish();
                return true;

            case R.id.new_game:
                guess= (int) (Math.random()*100);

                bControl.setText(getResources().getString(R.string.input_value));
                tvInfo.setText(getResources().getString(R.string.try_to_guess));
                game_finish=false;
                etInput.setText("");
                return true;




            default:
                return super.onOptionsItemSelected(item);
        }
    }


        public void onClick(View view) {
if (!isAllEditWithText()) {
    return;
}

       if (!game_finish) {
           int value = Integer.parseInt(etInput.getText().toString());
           if (value > guess){
               tvInfo.setText(getResources().getString(R.string.ahead));
           etInput.setText("");}
           if (value < guess){
               tvInfo.setText(getResources().getString(R.string.behind));
           etInput.setText("");}
           if (value == guess) {
               tvInfo.setText(getResources().getString(R.string.hit));
               bControl.setText(getResources().getString(R.string.play_more));
               game_finish = true;

           }
       }
        else {
            guess= (int) (Math.random()*100);

            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            game_finish=false;
           etInput.setText("");
        }

    }


    private boolean isAllEditWithText(){
        return (etInput.getText().length() !=0);
    }

    }
