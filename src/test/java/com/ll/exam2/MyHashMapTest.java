package com.ll.exam2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class MyHashMapTest {
    private MyHashMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new MyHashMap<>();
    }

    @Test
    @DisplayName("size()")
    void t01() {
        assertThat(map.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("put()")
    void t02() {
        assertNull(map.put("Key1", 1));
        assertEquals(1, map.size());
    }

    @Test
    @DisplayName("put() 같은 키 값에 다른 값을 넣으면 이전 값을 리턴하고 대체")
    void t03() {

        assertNull(map.put("철수", 22));

        map.put("영희", 23);

        assertThat(map.put("철수", 25)).isEqualTo(22);

    }

    @Test
    @DisplayName("get()")
    void t04() {
        map.put("철수", 22);
        map.put("영희", 23);

        int ageOf철수 = map.get("철수");
        int ageOf영희 = map.get("영희");

        assertThat(ageOf철수).isEqualTo(22);
        assertThat(ageOf영희).isEqualTo(23);
    }

    @Test
    @DisplayName("remove()")
    void t05() {
        map.put("철수", 22);
        map.put("영희", 23);

        assertThat(
                map.remove("영희")
        ).isEqualTo(23);

        assertThat(
                map.remove("영숙")
        ).isEqualTo(null);

        assertThat(map.size()).isEqualTo(1);
    }
}