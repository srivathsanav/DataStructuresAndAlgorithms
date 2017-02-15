package com.datastructures;

import java.util.Arrays;

/**
 * Created by srivathsan on 15/02/17.
 */
public class MinHeap {

    private int CAPACITY = 10;

    private int items[] = new int[CAPACITY];

    private int size = 0;

    public int getLeftChildIndex(int parentIndex) {
        return 2* parentIndex + 1;
    }

    public int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < size;
    }

    public boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < size;
    }

    public boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= 0;
    }

    public int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    public int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    public int parentIndex(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == CAPACITY) {
            CAPACITY = CAPACITY * 2;
            Arrays.copyOf(items, CAPACITY);
        }
    }

    public int poll() {
        if (size == 0) {
            throw  new IllegalStateException("Heap is empty");
        }
        int value = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return value;
    }

    public void add(int value) {
        ensureExtraCapacity();
        items[size] = value;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parentIndex(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }

    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int minIndex = getLeftChildIndex(index);
            if (hasRightChild(index)) {
                if (leftChild(index) > rightChild(index)) {
                    minIndex = getRightChildIndex(index);
                }
            }
            if (items[minIndex] < items[index]) {
                swap(minIndex, index);
                index = minIndex;
            } else {
                return;
            }
        }
    }

}
