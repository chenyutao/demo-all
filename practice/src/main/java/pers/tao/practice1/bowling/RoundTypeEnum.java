package pers.tao.practice1.bowling;

public enum RoundTypeEnum {
    ALL_IN_FIRST(1),
    ALL_BY_SECOND(2),
    NORMAL(3)
    ;


    RoundTypeEnum(int type) {
        this.type = type;
    }

    private int type;

    public int getType() {
        return type;
    }



}

