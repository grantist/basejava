package com.javops.webapp.storage;

import com.javops.webapp.exception.StorageException;
import com.javops.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by TRACTEL_RND on 07.06.2018.
 */
public class SortedArrayStorageTest extends ArrayAbstractStorageTest {
    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }

    @Test(expected = StorageException.class)
    public void saveOverFlow() throws Exception {
        try {
            for ( int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++ ) {
                storage.save(new Resume("A" + i));
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume("A"));
    }
}
