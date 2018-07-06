package com.example.user.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button option0;
    Button option1;
    Button option2;
    Button option3;
    TextView question;
    TextView timer;
    TextView scoreView;
    TextView textView;
    TextView textView2;
    Button playAgain;

    CountDownTimer countDownTimer;

    int score = 0;
    int total = 0;
    String finalScore = Integer.toString(score) + "/" + Integer.toString(total);
    Button startButton;
    String[] questions = {"Q1. What is 9 x 8?", "Q2. What is 15/3 ?", "Q3. What is 42/7 ?", "Q4. What is 81/9 ?", "Q5. What is 20/4 ?", "Q6. What is 75/5 ?", "Q7. What is 48/3 ?", "Q8. What is 108/12 ?", "Q9. What is 60/12 ?", "Q10. What is 169/13 ?", "Q11. What is 90 x 4 ?", "Q12. What is 50x7 ?", "Q13 What is 56/8 ?", "Q14. What is 23 x 3 ?", "Q15. What is 27 + 18 ?", "Q16. What is 26/2 ?"};
    String[] answers = {"72", "5", "6", "9", "5", "15", "16", "9", "5", "13", "360", "350", "7", "69", "45", "13"};
    int count = 0;

    public void nextQuestion(View view) {


        Button b = (Button) view;
//        Log.i("Answer:",b.getText().toString());

        if (b.getText().toString() == answers[count]) {
            score++;
        }

        question.setText(questions[count + 1]);

        Random useless0 = new Random();
        Random useless1 = new Random();
        Random useless2 = new Random();

        int ran0 = useless0.nextInt(100);
        int ran1 = useless1.nextInt(100);
        int ran2 = useless2.nextInt(100);
        Random choice = new Random();

        int choose = choice.nextInt(3);
        if (choose == 0) {
            option0.setText(answers[count + 1]);
            option1.setText(Integer.toString(ran0));
            option2.setText(Integer.toString(ran1));
            option3.setText(Integer.toString(ran2));

        } else if (choose == 1) {
            option0.setText(Integer.toString(ran0));
            option1.setText(answers[count + 1]);
            option2.setText(Integer.toString(ran1));
            option3.setText(Integer.toString(ran2));
        } else if (choose == 2) {
            option0.setText(Integer.toString(ran0));
            option1.setText(Integer.toString(ran1));
            option2.setText(answers[count + 1]);
            option3.setText(Integer.toString(ran2));
        } else if (choose == 3) {
            option0.setText(Integer.toString(ran0));
            option1.setText(Integer.toString(ran0));
            option2.setText(Integer.toString(ran1));
            option3.setText(answers[count + 1]);
        }

        count++;

        total++;
        String answer;
        Log.i("Count:", Integer.toString(count));
        Log.i("Score", Integer.toString(score));
        scoreView.setText(Integer.toString(score) + "/" + Integer.toString(count));

    }

    public void reset() {
        timer.setText("30");
        count = 0;
        startButton.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        timer.setVisibility(View.INVISIBLE);
        scoreView.setVisibility(View.INVISIBLE);
        option0.setVisibility(View.INVISIBLE);
        option1.setVisibility(View.INVISIBLE);
        option2.setVisibility(View.INVISIBLE);
        option3.setVisibility(View.INVISIBLE);
        question.setVisibility(View.INVISIBLE);
        count = 0;
        score = 0;

    }

    public void start(View view) {
        startButton.setVisibility(View.INVISIBLE);
        option0.setVisibility(View.VISIBLE);
        option1.setVisibility(View.VISIBLE);
        option2.setVisibility(View.VISIBLE);
        option3.setVisibility(View.VISIBLE);
        question.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.VISIBLE);
        timer.setVisibility(View.VISIBLE);
        scoreView.setVisibility(View.VISIBLE);


        countDownTimer = new CountDownTimer(30000 + 300, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(Long.toString(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                reset();
            }
        }.start();
        question.setText(questions[0]);
        Random useless0 = new Random();
        Random useless1 = new Random();
        Random useless2 = new Random();

        int ran0 = useless0.nextInt(100);
        int ran1 = useless1.nextInt(100);
        int ran2 = useless2.nextInt(100);

        Random choice = new Random();

        int choose = choice.nextInt(3);
        if (choose == 0) {
            option0.setText(answers[0]);
            option1.setText(Integer.toString(ran0));
            option2.setText(Integer.toString(ran1));
            option3.setText(Integer.toString(ran2));

        } else if (choose == 1) {
            option0.setText(Integer.toString(ran0));
            option1.setText(answers[0]);
            option2.setText(Integer.toString(ran1));
            option3.setText(Integer.toString(ran2));
        } else if (choose == 2) {
            option0.setText(Integer.toString(ran0));
            option1.setText(Integer.toString(ran1));
            option2.setText(answers[0]);
            option3.setText(Integer.toString(ran2));
        } else if (choose == 3) {
            option0.setText(Integer.toString(ran0));
            option1.setText(Integer.toString(ran0));
            option2.setText(Integer.toString(ran1));
            option3.setText(answers[0]);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.startButton);
        startButton.setVisibility(View.VISIBLE);
        option0 = (Button) findViewById(R.id.button0);
        option1 = (Button) findViewById(R.id.button1);
        option2 = (Button) findViewById(R.id.button2);
        option3 = (Button) findViewById(R.id.button3);
        question = (TextView) findViewById(R.id.questionTextView);
        timer = (TextView) findViewById(R.id.timerTextView);
        scoreView = (TextView) findViewById(R.id.scoreTextView);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        playAgain = (Button) findViewById(R.id.again);


        textView.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        timer.setVisibility(View.INVISIBLE);
        scoreView.setVisibility(View.INVISIBLE);
        option0.setVisibility(View.INVISIBLE);
        option1.setVisibility(View.INVISIBLE);
        option2.setVisibility(View.INVISIBLE);
        option3.setVisibility(View.INVISIBLE);
        question.setVisibility(View.INVISIBLE);
    }
}
