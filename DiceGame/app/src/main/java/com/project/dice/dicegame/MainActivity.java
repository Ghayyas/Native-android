package com.project.dice.dicegame;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int score;
    int die1;
    int die2;
    int die3;

    //Array List
    ArrayList<Integer> dice;
    //Array Image List
    ArrayList<ImageView> diceImageViews;

    TextView rollResult;
    //Button
    Button rollButton;
    //Random Num
    Random rand;
  //  Score View
    TextView scoreText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        score = 0;
        rollResult = (TextView) findViewById(R.id.rollResult);
        rollButton = (Button) findViewById(R.id.rollButton);
        scoreText = (TextView) findViewById(R.id.scoreText);

        rand = new Random();
        Toast.makeText(getApplicationContext(),"Wellcome to Dice",Toast.LENGTH_SHORT).show();
       //Array list Create

        dice = new ArrayList<Integer>();
        ImageView die1Image = (ImageView) findViewById(R.id.die1Image);
        ImageView die2Image = (ImageView) findViewById(R.id.die2Image);
        ImageView die3Image = (ImageView) findViewById(R.id.die3Image);
        diceImageViews = new ArrayList<ImageView>();
        diceImageViews.add(die1Image);
        diceImageViews.add(die2Image);
        diceImageViews.add(die3Image);
    }

      public void rollDice(View v){
//          rollResult.setText("Clicked");
          die1 = rand.nextInt(6)+1;
          die2 = rand.nextInt(6)+1;
          die3 = rand.nextInt(6)+1;

          // Storing in Array

          //Clear the Array
          dice.clear();
          dice.add(die1);
          dice.add(die2);
          dice.add(die3);


//       Toast.makeText(getApplicationContext(),randomNum,Toast.LENGTH_SHORT).show();
          for(int dieOfSet = 0; dieOfSet<3; dieOfSet++){
              String imageName = "die_"+ dice.get(dieOfSet)+".png";
             try{
                  InputStream stream = getAssets().open(imageName);
                  Drawable d = Drawable.createFromStream(stream,null);
                  diceImageViews.get(dieOfSet).setImageDrawable(d);
              }
              catch (IOException e){
                  e.printStackTrace();
              }
          }
          String msg;
          if(die1==die2 && die1==die3){
              //Triples
              int scoreDelta = die1 *100;
              msg = "You Rolled a Tiple " + die1 + "You Score " + scoreDelta + "Points.";
              score+=scoreDelta;
          }
          else if(die1 == die2 || die1 == die3 || die2 == die3){
              //Doubles
              msg = "You Rolled Doubles";
              score+=50;

          }
          else{
              msg = "You Didn't Score Try Again !";
          }
          rollResult.setText(msg);
          scoreText.setText("Score:" + score);
      }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
