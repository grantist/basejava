package com.javops.webapp.storage;

import com.javops.webapp.storage.strategy.ObjectStreamStorage;

public class ObjectStreamStorageTest extends AbstractStorageTest {

    public ObjectStreamStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectStreamStorage()));
    }
}