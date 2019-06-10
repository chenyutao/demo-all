package pers.tao.practice1.test;

import pers.tao.practice1.bowling.Competition;
import pers.tao.practice1.bowling.Round;

/**
 * @author: chenyutao
 * @date: 2019-06-09 12:46
 */
public class MyTest {
    private ThreadLocal<Competition> threadLocal= new ThreadLocal<Competition>();

    @org.junit.Test
    public void test() {
        Competition competition = new Competition();
        inputRoundData(competition,1,4);
        inputRoundData(4,5);
        inputRoundData(6,4);
        inputRoundData(5,5);
        inputRoundData(10);
        inputRoundData(0,1);
        inputRoundData(7,3);
        inputRoundData(6,4);
        inputRoundData(10);
        inputRoundData(2,8,6);
        int totalScore = competition.computeTotalScore();
        System.out.println(totalScore);

    }

    private void inputRoundData(Competition competition,Integer... hitCount){
        competition.addRound(new Round(hitCount));
        threadLocal.set(competition);

    }

    private void inputRoundData(Integer... hitCount){
        Competition competition = threadLocal.get();
        competition.addRound(new Round(hitCount));
    }

}

