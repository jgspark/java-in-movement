package com.onejkspark.example.pattern.adapter;

public class AdapterImpl implements Adapter {
    @Override
    public Float twiceOf(Float val) {
        return MathUtils.doubled(val.doubleValue()).floatValue();
    }

    @Override
    public Float halfOf(Float val) {
        System.out.println("half of 함수 호출");
        float value = (float) MathUtils.halfNum(val.doubleValue());
        System.out.println("half of 함수 호출" + value);
        return value;
    }
}
