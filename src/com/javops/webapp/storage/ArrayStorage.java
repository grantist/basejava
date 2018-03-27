package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[3];
    private int size = 0;//количество элементов в массиве


    public boolean isEmpty() { //метод возвращает true, если массив пустой
        return (size == -1);
    }

    public boolean isFull() { //  метод возвращает true, если массив переполнен
        return (size == 3);
    }

    public boolean find(Resume r) // Поиск заданного значения в массиве
    {
        int i;
        for (i = 0; i < size; i++) { // Для каждого элемента
            if (storage[i] == r) { // Значение найдено?
                break;
            }// Да - выход из цикла
            if (i ==size) { // Достигнут последний элемент?
                return false; // Да
            }
        }
        return true; //Нет
    }

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void update(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(r.getUuid())) {
                storage[i] = r;
                System.out.println("The resume has updated!");
            } else System.out.println("Can't find the resume!");
        }
    }

    public void save(Resume r) {
        if (!isFull()) {
            if (!find(r)) {
                storage[size] = r;
                size++;
            } else {
                System.out.println("Array has this resume!");
            }
        } else {
            System.out.println("Can't add resume. The array is overflowed!");

        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            } else {
                System.out.println("Can't find the resume");
            }
        }
        return null;
    }

    public void delete(String uuid) {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    size--;
                    storage[i] = storage[size];
                    storage[size] = null;
                } else {
                    System.out.println("Can't find the resume!");
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
}
