package com.udacity.wertonguimaraes.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mGoalTeamA;
    private TextView mFaultTeamA;
    private TextView mCardTeamA;
    private Button mAddGoalTeamA;
    private Button mAddFaultTeamA;
    private Button mAddCardTeamA;

    private TextView mGoalTeamB;
    private TextView mFaultTeamB;
    private TextView mCardTeamB;
    private Button mAddGoalTeamB;
    private Button mAddFaultTeamB;
    private Button mAddCardTeamB;

    private Button mReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInitView();
        mInitButtonListeners();
    }

    private void mInitView() {
        mGoalTeamA = (TextView) findViewById(R.id.total_goal_team_a);
        mFaultTeamA = (TextView) findViewById(R.id.total_fault_team_a);
        mCardTeamA = (TextView) findViewById(R.id.total_card_team_a);
        mAddGoalTeamA = (Button) findViewById(R.id.add_goal_a);
        mAddFaultTeamA = (Button) findViewById(R.id.add_fault_a);
        mAddCardTeamA = (Button) findViewById(R.id.add_card_a);

        mGoalTeamB = (TextView) findViewById(R.id.total_goal_team_b);
        mFaultTeamB = (TextView) findViewById(R.id.total_fault_team_b);
        mCardTeamB = (TextView) findViewById(R.id.total_card_team_b);
        mAddGoalTeamB = (Button) findViewById(R.id.add_goal_b);
        mAddFaultTeamB = (Button) findViewById(R.id.add_fault_b);
        mAddCardTeamB = (Button) findViewById(R.id.add_card_b);

        mReset = (Button) findViewById(R.id.reset);

    }

    private void mInitButtonListeners() {
        mAddGoalTeamA.setOnClickListener(mAddPointListener);
        mAddFaultTeamA.setOnClickListener(mAddPointListener);
        mAddCardTeamA.setOnClickListener(mAddPointListener);

        mAddGoalTeamB.setOnClickListener(mAddPointListener);
        mAddFaultTeamB.setOnClickListener(mAddPointListener);
        mAddCardTeamB.setOnClickListener(mAddPointListener);

        mReset.setOnClickListener(mAddPointListener);
    }

    private View.OnClickListener mAddPointListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.add_goal_a:
                    mAddPoints(mGoalTeamA, 1);
                    break;
                case R.id.add_fault_a:
                    mAddPoints(mFaultTeamA, 1);
                    break;
                case R.id.add_card_a:
                    mAddPoints(mCardTeamA, 1);
                    break;
                case R.id.add_goal_b:
                    mAddPoints(mGoalTeamB, 1);
                    break;
                case R.id.add_fault_b:
                    mAddPoints(mFaultTeamB, 1);
                    break;
                case R.id.add_card_b:
                    mAddPoints(mCardTeamB, 1);
                    break;
                case R.id.reset:
                    mResetAllPoints();
                    break;
                default:
                    break;
            }
        }
    };

    private void mAddPoints(TextView textView, int point){
        int oldPoints = Integer.parseInt(textView.getText().toString());
        String currentPoints = String.valueOf(oldPoints + point);
        textView.setText(currentPoints);
    }

    private void mResetAllPoints(){
        mResetSpecificPoint(mGoalTeamA);
        mResetSpecificPoint(mFaultTeamA);
        mResetSpecificPoint(mCardTeamA);
        mResetSpecificPoint(mGoalTeamB);
        mResetSpecificPoint(mFaultTeamB);
        mResetSpecificPoint(mCardTeamB);
    }

    private void mResetSpecificPoint(TextView textView){
        textView.setText("0");
    }
}
