package com.javops.webapp.storage;

import com.javops.webapp.storage.serializer.JsonStreamSerializer;
import com.javops.webapp.storage.serializer.XmlStreamSerializer;

public class JsonPathStorageTest extends AbstractStorageTest {

    public JsonPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new JsonStreamSerializer()));
    }
}
