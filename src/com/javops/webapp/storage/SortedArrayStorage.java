package com.javops.webapp.storage;

import com.javops.webapp.model.Resume;

import static java.util.Arrays.*;

/**
 * Created by TRACTEL_RND on 04.04.2018.
 */
public class SortedArrayStorage extends AbstractArrayStorage {


    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }

    @Override
    protected void insertElement(Resume resume, int index) {
        //https://codereview.stackexchange.com/questions/36221/binary-search-for-inserting-in-array
        int insertIdx = -index - 1;
        System.arraycopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx);
        storage[insertIdx] = resume;

    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return binarySearch(storage, 0, size, searchKey);
    }

}
