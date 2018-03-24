import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int numberOfElements = 0;//количество элементов в массиве

    void clear() {
        Arrays.fill(storage, null);
        numberOfElements = 0;
    }

    void save(Resume r) {
        storage[numberOfElements] = r;
        numberOfElements++;
    }

    Resume get(String uuid) {
        int i;
        for (i = 0; i < numberOfElements; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        numberOfElements--;
        for (int i = 0; i < numberOfElements; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[numberOfElements];
                storage[numberOfElements] = null;

            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, numberOfElements);
    }

    int size() {
        return numberOfElements;
    }
}
