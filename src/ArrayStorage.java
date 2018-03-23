import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int nElems = 0;//количество элементов в массиве

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        storage[nElems] = r;
        nElems++;

    }

    Resume get(String uuid) {
        int j;
        for (j = 0; j < nElems; j++)
            if (storage[j].equals(uuid))
                break;
        return storage[j];
    }

    void delete(String uuid) {
        for (int j = 0; j < nElems; j++)
            if (storage[j].equals(uuid)) {
                storage[j] = storage[nElems - 1];
                storage[nElems - 1] = null;
                nElems--;
            }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, nElems);
    }

    int size() {
        return nElems;
    }
}
