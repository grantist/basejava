package com.javops.webapp.storage;

import com.javops.webapp.exception.StorageException;
import com.javops.webapp.model.Resume;
import com.javops.webapp.storage.strategy.StorageStrategy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractPathStorage extends AbstractStorage<Path> {
    private Path directory;
    private StorageStrategy storageStrategy;

    protected AbstractPathStorage(String dir, StorageStrategy storageStrategy) {
        directory = Paths.get(dir);
        this.storageStrategy = storageStrategy;
        Objects.requireNonNull(directory, "directory must not be null");
        if (Files.isDirectory(directory) || Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is nor directory or is nor writeable");
        }
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::doDelete);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }
    }

    @Override
    public int size() {
        try {
            return (int) Files.size(directory);
        } catch (IOException | SecurityException e) {
            throw new StorageException("Directory read error", null);
        }
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Path path) {
        try {
            storageStrategy.doWrite(r, new BufferedOutputStream(Files.newOutputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Path write error", r.getUuid(), e);
        }
    }

    @Override
    protected boolean isExist(Path path) {
        return Files.exists(path);
    }

    @Override
    protected void doSave(Resume r, Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("Couldn't create Path " + path.toAbsolutePath(), path.getFileSystem().toString(), e);
        }
        doUpdate(r, path);
    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return storageStrategy.doRead(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Path read error", path.getFileName().toString(), e);
        }
    }

    @Override
    protected void doDelete(Path path) {
        try {
            Files.delete(path);
        } catch (IOException | SecurityException e) {
            System.err.println(e);
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        try {
            Stream<Path> list = Files.list(directory);
            return list.map(this::doGet).collect(Collectors.toList());
        } catch (IOException e) {
            throw new StorageException("Directory read error", null);
        }
    }
}
