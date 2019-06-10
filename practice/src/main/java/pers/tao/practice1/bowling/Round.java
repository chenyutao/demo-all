package pers.tao.practice1.bowling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一场比赛中有若干轮
 *
 * @author: chenyutao
 * @date: 2019-06-09 12:43
 */

public class Round {
    public static int totalBottleNumber = 10;

    private int roundType;

    private List<Integer> hitCounts = new ArrayList<Integer>();

    public int getRoundType() {
        return roundType;
    }

    public List<Integer> getHitCounts() {
        return hitCounts;
    }

    public Round(Integer... hitCount) {
        hitCounts.addAll(Arrays.asList(hitCount));
        if(hitCount[0]==totalBottleNumber){
            roundType = RoundTypeEnum.ALL_IN_FIRST.getType();
        }else if(hitCount[0]+hitCount[1]==totalBottleNumber){
            roundType = RoundTypeEnum.ALL_BY_SECOND.getType();
        }else {
            roundType = RoundTypeEnum.NORMAL.getType();
        }
    }

}
