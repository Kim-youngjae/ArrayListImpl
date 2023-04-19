package com.ll.exam1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyArrayListTest {
    @Test
    @DisplayName("testSize")
    void t1() {
        MyArrayList<String> list = new MyArrayList<>();
        assertThat(list.size()).isEqualTo(0);
    }

    // 추가기능 테스트
    @Test
    @DisplayName("add(\"사과\")")
    void t2(){
        MyArrayList<String> list = new MyArrayList<>();

        list.add("사과");
        list.add("포도");

        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("get(\"포도\")")
    void t3(){
        MyArrayList<String> list = new MyArrayList<>();

        list.add("사과");
        list.add("포도");

        assertThat(list.get(0)).isEqualTo("사과");
        assertThat(list.get(1)).isEqualTo("포도");
    }

    @Test
    @DisplayName("data(배열)의 크기가 자동으로 늘어나야 한다.")
    void t4(){
        MyArrayList<String> list = new MyArrayList<>();

        String[] data = TestUt.getFieldValue(list, "data", null);
        assertThat(data.length).isEqualTo(2);

        list.add("사과");
        list.add("포도");

        data = TestUt.getFieldValue(list, "data", null);
        assertThat(data.length).isEqualTo(2);

        list.add("당근");

        data = TestUt.getFieldValue(list, "data", null);
        assertThat(data.length).isEqualTo(4);

        assertThat(list.size()).isEqualTo(3);
    }
}