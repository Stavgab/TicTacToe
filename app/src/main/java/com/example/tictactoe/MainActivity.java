package com.example.tictactoe;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/*
    TicTacToe by:
    Stav Gabay    ID: 205388721
    Noam Dadush   ID: 208936336
 */

public class MainActivity extends AppCompatActivity {

    TextView title;
    Button[] ticTacToeBtn;
    int stepNumber;
    List<Integer> player1, player2;

    static final String BACKGROUND_GREEN = "#31E810";
    static final String BACKGROUND_PINK = "#E91E63";
    static final String BACKGROUND_BLUE = "#2196F3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        title = findViewById(R.id.main_activity_title);
        title.setText("Tic Tac Toe");
        stepNumber = 0;
        player1 = new ArrayList<>();
        player2 = new ArrayList<>();

        ticTacToeBtn = new Button[10];

        ticTacToeBtn[0] = findViewById(R.id.button0);
        ticTacToeBtn[1] = findViewById(R.id.button1);
        ticTacToeBtn[2] = findViewById(R.id.button2);
        ticTacToeBtn[3] = findViewById(R.id.button3);
        ticTacToeBtn[4] = findViewById(R.id.button4);
        ticTacToeBtn[5] = findViewById(R.id.button5);
        ticTacToeBtn[6] = findViewById(R.id.button6);
        ticTacToeBtn[7] = findViewById(R.id.button7);
        ticTacToeBtn[8] = findViewById(R.id.button8);
        ticTacToeBtn[9] = findViewById(R.id.btn_status);

        for (int i = 0; i < 10; i++) {
            ticTacToeBtn[i].setOnClickListener(this::onClick);
        }
    }

    public void checkStatus(List<Integer> player, int num1, int num2, int num3, String name){
        if(player.contains(num1) && player.contains(num2) && player.contains(num3)) {
            ticTacToeBtn[num1].setBackgroundColor(Color.parseColor(BACKGROUND_GREEN));
            ticTacToeBtn[num2].setBackgroundColor(Color.parseColor(BACKGROUND_GREEN));
            ticTacToeBtn[num3].setBackgroundColor(Color.parseColor(BACKGROUND_GREEN));
            title.setText(name + " Win This Game!");
            ticTacToeBtn[9].setText("Play Again!");
            for (int i = 0; i < 9; i++) {
                if (i != num1 || i != num2 || i != num3) {
                    ticTacToeBtn[i].setEnabled(false);
                }
            }
        }
    }
    public void onClick(View view){
        int tag = Integer.parseInt(view.getTag().toString());
        if(tag != 9){
            stepNumber++;
            if(stepNumber == 1){
                ticTacToeBtn[9].setText("Clean the board");
            }
            if(stepNumber == 9){
                ticTacToeBtn[9].setText("Play Again!");
            }
            if(stepNumber % 2 == 1){
                player1.add(tag);
                ticTacToeBtn[tag].setText("X");
                ticTacToeBtn[tag].setBackgroundColor(Color.parseColor(BACKGROUND_PINK));
            }else{
                player2.add(tag);
                ticTacToeBtn[tag].setText("O");
                ticTacToeBtn[tag].setBackgroundColor(Color.parseColor(BACKGROUND_BLUE));
            }
            ticTacToeBtn[tag].setEnabled(false);
            if(stepNumber > 4){
                if(stepNumber % 2 == 1){
                    checkStatus(player1, 0, 1 ,2,"X");
                    checkStatus(player1, 3, 4 ,5,"X");
                    checkStatus(player1, 6, 7 ,8,"X");
                    checkStatus(player1, 0, 3 ,6,"X");
                    checkStatus(player1, 1, 4 ,7,"X");
                    checkStatus(player1, 2, 5 ,8,"X");
                    checkStatus(player1, 0, 4 ,8,"X");
                    checkStatus(player1, 2, 4 ,6,"X");
                }else{
                    checkStatus(player2, 0, 1 ,2,"O");
                    checkStatus(player2, 3, 4 ,5,"O");
                    checkStatus(player2, 6, 7 ,8,"O");
                    checkStatus(player2, 0, 3 ,6,"O");
                    checkStatus(player2, 1, 4 ,7,"O");
                    checkStatus(player2, 2, 5 ,8,"O");
                    checkStatus(player2, 0, 4 ,8,"O");
                    checkStatus(player2, 2, 4 ,6,"O");
                }
            }
        }
        else{
            finish();
            startActivity(getIntent());
        }
    }
}