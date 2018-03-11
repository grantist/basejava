import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[5];
    Resume[] array;
    private int nElems=0;//количество элементов в массиве

    void clear() {
       Arrays.fill(storage,null);
    }

    void save(Resume r) {
       storage[nElems]=r;
       nElems++;

    }
    Resume get(String uuid) {
        int j;
        for(j=0; j<nElems; j++)
            if (storage[j].toString().equals(uuid))
                break;
            return storage[j];
    }
    void delete(String uuid) {
        for(int j=0; j<nElems; j++)
            if(storage[j].toString().equals(uuid)) {
                storage[j]=storage[nElems-1];
                  nElems--;
            }
        }
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        array=Arrays.copyOfRange(storage,0,nElems);
        return array;
    }

    int size() {
        return nElems ;
    }
}
