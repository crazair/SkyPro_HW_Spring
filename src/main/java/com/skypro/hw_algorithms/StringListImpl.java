package com.skypro.hw_algorithms;

public class StringListImpl implements StringList {

    private String[] array;
    private int capacity;
    private int size = 0;

    public StringListImpl() {
        this(10);
    }

    public StringListImpl(int capacity) {
        this.capacity = capacity;
        array = new String[capacity];
    }

    @Override
    public String add(String item) {
        return add(size, item);
    }

    @Override
    public String add(int index, String item) {
        if (index > size || index < 0) {
            throw new RuntimeException("Такой ячейки нет в массиве");
        }
        if (item == null || item.isBlank()) {
            throw new RuntimeException("Введена пустая строка");
        }
        if (capacity <= size) {
            increase();
        }
        int i;
        for (i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[i] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index >= size || index < 0) {
            throw new RuntimeException("Такой ячейки нет в массиве");
        }
        if (item == null || item.isBlank()) {
            throw new RuntimeException("Введена пустая строка");
        }
        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                index = i;
            }
        }
        if (index == -1) {
            throw new RuntimeException("Нет такого элемента");
        } else return remove(index);
    }

    @Override
    public String remove(int index) {
        if (index >= size || index < 0) {
            throw new RuntimeException("Такой ячейки нет в массиве");
        }
        String temp = array[index];
        if (size - 1 - index >= 0) System.arraycopy(array, index + 1, array, index, size - 1 - index);
        array[size] = null;
        size--;
        return temp;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i > -1; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= size || index < 0) {
            throw new RuntimeException("Такой ячейки нет в массиве");
        }
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new RuntimeException("Пустой список");
        }
        if (this.size != otherList.size()) return false;
        for (int i = 0; i < size; i++) {
            if (!(array[i].equals(otherList.get(i)))) return false;
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] result = new String[size];
        System.arraycopy(array, 0, result, 0, size);
        return result;
    }

    private void increase() {
        capacity += (capacity / 2 + 1);
        String[] temp = new String[capacity];
        System.arraycopy(array, 0, temp, 0, size);
        array = temp;
    }

}
