package com.javops.webapp.storage;

import com.javops.webapp.exception.StorageException;
import com.javops.webapp.model.Resume;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public abstract class AbstractPathStorage extends AbstractStorage<Path> {
    private Path directory;

    protected abstract void doWrite(Resume r, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;

    protected AbstractPathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (Files.isDirectory(directory) || Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is nor directory or is nor writeable");
        }
        this.directory = directory;
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(new Consumer<Path>() {
                @Override
                public void accept(Path path) {
                    doDelete(path);
                }
            });
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }
    }

    @Override
    public int size() {
        int size = 0;
        try {
            size = (int) Files.size(directory);
            if (size == 0) {
                throw new StorageException("Directory read error", null);
            }
        } catch (IOException | SecurityException e) {
            System.err.println(e);
        }
        return size;
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return Paths.get(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Path path) {
        try {
            doWrite(r, Files.newOutputStream(path));
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
            return doRead(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Path read error", path.getFileName().toString(), e);
        }
    }

    @Override
    protected void doDelete(Path path) {
        try {
            Files.delete(path);
            {
                if (!Files.exists(path))
                    throw new StorageException("Path delete error", path.getFileName().toString());
            }
        } catch (IOException | SecurityException e) {
            System.err.println(e);
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        if (directory == null) {
            throw new StorageException("Directory read error", null);
        }
        List<Resume> list = new ArrayList<>();
        for (Path path : directory) {
            list.add(doGet(path));
        }
        return list;
    }
}
