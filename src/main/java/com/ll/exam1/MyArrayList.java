package com.ll.exam1;

public class MyArrayList<T> {
    private String[] data = new String[2];
    private int size = 0;

    MyArrayList() {
    }

    //리스트의 사이즈를 리턴
    public int size() {
        return size;
    }

    public boolean add(String element) {
        // 더할 때마다 공간을 추가해주어야 한다.
        // 데이터 공간이 부족하면 새 데이터 객체를 만든다.
        makeNewSpaceIfNotEnough();

        data[size] = element;

        size++;

        return true;
    }

    private void makeNewSpaceIfNotEnough() {
        if (isFull()) {
            makeNewSpace();
        }
    }

    private void makeNewSpace() {
        String[] newSpace = new String[data.length * 2]; // 기존

        // 기존 저장된 요소들을 전부 새로만든 공간에 옮긴다.
        for (int i = 0; i < data.length; i++) {
            newSpace[i] = data[i];
        }

        data = newSpace;
    }

    private boolean isFull() {
        return size >= data.length;
    }

    public String get(int index) {
        return data[index];
    }
}
