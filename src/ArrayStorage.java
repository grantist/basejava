/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    Resume[] array;
    private int nElems=0;//количество элементов в массиве

    void clear() {
        for (int i=0;i<storage.length;i++){
            storage[i]=null;
        }
    }

    void save(Resume r) {
       storage[nElems]=r;
       nElems++;

    }
    Resume get(String uuid) {
        Resume temStorage=null;
        for(int j=0; j<nElems; j++) {
            if (storage[j].toString().equals(uuid))
                temStorage = storage[j];
        }
        return temStorage;
    }
    void delete(String uuid) {
        for(int j=0; j<nElems; j++)
            if(storage[j].toString().equals(uuid)) {
                for (int k = j; k < nElems; k++)
                    storage[k] = storage[k + 1];
                nElems--;
            }
        }
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        array=new Resume[storage.length];
        for (int i=0;i<storage.length;i++){
            if (storage[i]!=null){
            array[i]=storage[i];
            }
            else break;
        }
        return array;
    }

    int size() {
        return nElems ;
    }
}
