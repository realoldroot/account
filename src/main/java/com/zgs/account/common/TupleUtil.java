package com.zgs.account.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhengenshen
 * @date 2018-12-13 14:43
 */
public class TupleUtil {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Tuple1<T1> {
        private T1 val1;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Tuple2<T1, T2> implements Serializable {
        private T1 val1;
        private T2 val2;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Tuple3<T1, T2, T3> implements Serializable {
        private T1 val1;
        private T2 val2;
        private T3 val3;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Tuple4<T1, T2, T3, T4> implements Serializable {
        private T1 val1;
        private T2 val2;
        private T3 val3;
        private T4 val4;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Tuple5<T1, T2, T3, T4, T5> implements Serializable {
        private T1 val1;
        private T2 val2;
        private T3 val3;
        private T4 val4;
        private T5 val5;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Tuple6<T1, T2, T3, T4, T5, T6> implements Serializable {
        private T1 val1;
        private T2 val2;
        private T3 val3;
        private T4 val4;
        private T5 val5;
        private T6 val6;
    }
}
