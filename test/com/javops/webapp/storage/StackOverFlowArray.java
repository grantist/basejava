package com.javops.webapp.storage;

import com.javops.webapp.exception.StorageException;
import com.javops.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by TRACTEL_RND on 05.07.2018.
 */
public abstract class StackOverFlowArray extends AbstractStorageTest {

    public StackOverFlowArray(Storage storage) {
        super(storage);
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



