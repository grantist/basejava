package com.javops.webapp.storage;

import com.javops.webapp.storage.strategy.ObjectStreamStorage;

public class ObjectStreamPathStorageTest extends AbstractStorageTest {

    public ObjectStreamPathStorageTest() {
        super(new AbstractPathStorage(STORAGE_PATH, new ObjectStreamStorage()));
    }
}