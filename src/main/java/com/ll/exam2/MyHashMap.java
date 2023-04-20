package com.ll.exam2;

public class MyHashMap<K, V> {
    private int size = 0;

    private Entry[] entries;

    public V remove(K key) {
        int index = indexOfKey(key); // 키가 있는지 확인

        if (index == -1) {
            return null;
        }

        V oldValue = (V) entries[index].value;

        // 뒤에 있는 값을 앞으로 당겨줘야 한다.
        for (int i = index + 1; i < size; i++) {
            entries[i - 1] = entries[i];
        }

        entries[size - 1] = null;
        size--; // 마지막 값을 지워주기

        return oldValue;
    }

    private static class Entry<K, V> {
        // hashmap 클래스 안에서만 사용되는 클래스라서 private로 설정 해주었다.
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }


    MyHashMap() {
        this(2);
    }

    public MyHashMap(int initLength) {
        entries = new Entry[initLength];
    }

    public int size() {
        return size;
    }

    public V put(K key, V value) {
        int index = indexOfKey(key);

        makeNewArrayIfNotEnough();

        // 없는 값이면 새로 생성해서 넣어줌
        if (index != -1) {
            V oldValue = (V) entries[index].value;

            entries[index].value = value;

            return oldValue;
        }

        // 넣는데 같은 키 값이 존재하면 replace가 일어나야 함
        entries[size] = new Entry(key, value);

        size++;
        return null;
    }

    private void makeNewArrayIfNotEnough() {
        if (isNotEnough()) {
            makeNewArray();
        }
    }

    private void makeNewArray() {
        // 새 배열을 만든다.(새 업체를 만든다.)
        Entry[] newEntries = new Entry[entries.length * 2];

        // 기존 창고에 있던 물품들을 전부 새 창고로 옮긴다.
        for (int i = 0; i < entries.length; i++) {
            newEntries[i] = entries[i];
        }

        // 기존 창고과 계약을 해지한다.
        // 더 이상 리스트가 기존 배열을 가리키지 않도록 하여, 자연스럽게 가비지컬렉팅이 되도록 한다.
        entries = newEntries;
    }

    private boolean isNotEnough() {
        return size >= entries.length;
    }

    public V get(K key) {

        int index = indexOfKey(key);

        if (index != -1) {
            return (V) entries[index].value; // Object 배열이라서 제네릭 타입으로 형변환
        }

        return null;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key.equals(entries[i].key)) {
                return i;
            }
        }
        return -1;
    }
}
