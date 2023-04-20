package com.ll.exam1;

public class MyArrayList<T> {
    public boolean debug = false;
    private Object[] data;
    private int size = 0;

    MyArrayList() {
        this(2);
    }

    // 가변 배열이지만 초기크기를 지정할 수 있도록
    public MyArrayList(int dataLength) {
        data = new Object[dataLength];
    }

    //리스트의 사이즈를 리턴
    public int size() {
        return size;
    }

    public boolean add(T element) {
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
        Object[] newSpace = new Object[data.length * 2]; // 기존

        // 기존 저장된 요소들을 전부 새로만든 공간에 옮긴다.
        for (int i = 0; i < data.length; i++) {
            newSpace[i] = data[i];
        }

        if (debug) {
            System.out.printf("배열크기 증가 : %d => %d\n", data.length, newSpace.length);
        }

        data = newSpace;
    }

    private boolean isFull() {
        return size >= data.length;
    }

    // 해당 위치의 원소를 반환
    public Object get(int index) {
        return data[index];
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return i;
            }
        }

        return -1;
    }
}
