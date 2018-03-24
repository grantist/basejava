import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int Elems = 0;//количество элементов в массиве

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        storage[Elems] = r;
        Elems++;
    }

    Resume get(String uuid) {
        int i;
        for (i = 0; i < Elems; i++) {
            if (storage[i].uuid.equals(uuid)) {
                break;
            }
        }
        return storage[i];
    }

    void delete(String uuid) {
        for (int i = 0; i < Elems; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[Elems - 1];
                storage[Elems - 1] = null;
                Elems--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, Elems);
    }

    int size() {
        return Elems;
    }
}
