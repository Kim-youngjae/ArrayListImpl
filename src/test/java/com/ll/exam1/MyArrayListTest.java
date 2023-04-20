package com.ll.exam1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
class MyArrayListTest {
    @Test
    @DisplayName("testSize")
    void t01() {
        MyArrayList<String> list = new MyArrayList<>();
        assertThat(list.size()).isEqualTo(0);
    }

    // 추가기능 테스트
    @Test
    @DisplayName("add(\"사과\")")
    void t2() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("사과");
        list.add("포도");

        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("get(\"포도\")")
    void t03() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("사과");
        list.add("포도");

        assertThat(list.get(0)).isEqualTo("사과");
        assertThat(list.get(1)).isEqualTo("포도");
    }

    @Test
    @DisplayName("data(배열)의 크기가 자동으로 늘어나야 한다.")
    void t04() {
        MyArrayList<String> list = new MyArrayList<>();

        // 초창기 배열의 길이
        int dataLength1 = ((String[]) (TestUt.getFieldValue(list, "data", null))).length;

        // IntStream.range(0, 10); // [0...9]
        // 딱 1번 넘칠만큼의 데이터를 넣는다.
        IntStream.range(0, dataLength1 + 1)
                .forEach(index -> list.add("사과 %d".formatted(index)));

        int dataLength2 = ((String[]) (TestUt.getFieldValue(list, "data", null))).length;
        assertThat(dataLength2).isGreaterThan(dataLength1);
    }

    @Test
    @DisplayName("초기 data(배열)의 크기 설정")
    void t05() {
        // 초기 배열의 크기를 지정
        MyArrayList<String> list = new MyArrayList<>(200);

        // 배열의 길이
        int dataLength = ((String[]) (TestUt.getFieldValue(list, "data", null))).length;

        assertThat(dataLength).isEqualTo(200);
    }

    @Test
    @DisplayName("디버그 : 데이터를 많이 넣으면 배열증가가 많이 발생함")
    void t06() {
        MyArrayList<String> list = new MyArrayList<>();
        list.debug = true;

        // IntStream.range(0, 10); = [0, ... 9] 까지의 int 스트림 발생
        // 딱 1번 넘칠만큼의 데이터를 넣는다.
        IntStream.range(0, 100)
                .forEach(index -> list.add("사과 %d".formatted(index)));
    }

    @Test
    @DisplayName("디버그 : 초기 배열 크기 설정을 해줄 경우 배열이동이 줄어듬")
    void t07() {
        MyArrayList<String> list = new MyArrayList<>(25);
        list.debug = true;

        // IntStream.range(0, 10); = [0, ... 9] 까지의 int 스트림 발생
        // 딱 1번 넘칠만큼의 데이터를 넣는다.
        IntStream.range(0, 100)
                .forEach(index -> list.add("사과 %d".formatted(index)));
    }

    @Test
    @DisplayName("indexOf 테스트")
    void t08() {
        MyArrayList<String> list = new MyArrayList<>(100);

        IntStream.range(0, 100)
                .forEach(index -> list.add("사과 %d".formatted(index)));

        assertThat(list.indexOf("사과 0")).isEqualTo(0);
        assertThat(list.indexOf("사과 1")).isEqualTo(1);
        assertThat(list.indexOf("사과 22")).isEqualTo(22);
        assertThat(list.indexOf("사과 100")).isEqualTo(-1);
    }

    @Test
    @DisplayName("다양한 타입을 받을 수 있도록 Object로 변경")
    void t09() {
        MyArrayList<Boolean> list = new MyArrayList<>();

        list.add(true);
        list.add(false);

        assertThat(list.size()).isEqualTo(2);
    }
}