package pers.tao.practice1.bowling;

import pers.tao.util.CustomException;

import java.util.ArrayList;
import java.util.List;

/**
 * 比赛
 *
 * @author: chenyutao
 * @date: 2019-06-09 12:42
 */
public class Competition {
    public Competition() {

    }

    public static int RoundNo_Max = 10;

    /**
     * 对于一轮中，击倒全部木瓶的情况，取当前轮及之后的累计3次投掷击倒总数，做为得分。
     */
    private static int ScoreHitTimes_HitAll = 3;

    private Round[] rounds = new Round[RoundNo_Max];

    private int current = 1;

    /**
     * 本局比赛结束与否的标记位
     */
    private boolean flag = false;


    public void addRound(Round round){
        if(current>RoundNo_Max){
            throw new CustomException("参数错误-比赛结束");
        }
        rounds[current-1] =round;
        current++;
    }

    public int getCurrentRoundIndex(){
        return current;
    }

    public int computeCurrentRoundScore(){
        return computeScore(current);
    }

    public int computeScore(int roundIndex){
        if(roundIndex> RoundNo_Max || roundIndex<0){
            throw new CustomException("参数错误-轮数错误1");
        }
        Round round = rounds[roundIndex-1];
        if(round == null){
            throw new CustomException("参数错误-轮数错误2");
        }

        // not hit all
        if(round.getRoundType()==RoundTypeEnum.NORMAL.getType()){
            List<Integer> hitCounts = round.getHitCounts();
            return hitCounts.get(0) +hitCounts.get(1);
        }

        // hit all
        List<Integer> hitCountList = new ArrayList<Integer>();
        while (hitCountList.size()<ScoreHitTimes_HitAll && roundIndex <=RoundNo_Max ){
            round = rounds[roundIndex-1];
            List<Integer> hitCounts = round.getHitCounts();
            hitCountList.addAll(hitCounts);
            roundIndex++;

        }
        return hitCountList.get(0)+hitCountList.get(1)+hitCountList.get(2);
    }

    public int computeTotalScore(){
        if(current!=RoundNo_Max+1){
            throw new CustomException("参数错误-比赛未结束");
        }
        int totalScore = 0;
        for (int i = 1; i < RoundNo_Max+1; i++) {
            totalScore+=computeScore(i);
        }
        return totalScore;
    }

}
