package ru.job4j.thread.search;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class DirectoryVisitor extends SimpleFileVisitor<Path> {
    /**
     * Root.
     */
    private String root;
    /**
     * Extension.
     */
    private String ext;
    /**
     * Text.
     */
    private String text;
    /**
     * Results.
     */
    private List<String> results;

    /**
     * DirectoryVisitor constructor.
     * @param root - root.
     * @param ext - extension.
     * @param text - text.
     * @param results - results.
     */
    public DirectoryVisitor(String root, String ext, String text, List<String> results) {
        this.root = root;
        this.results = results;
        this.ext = ext;
        this.text = text;
    }

    /**
     * Do this when visit file.
     * @param path - path.
     * @param attrs - attr.
     * @return FileVisitResult.
     * @throws IOException - exception.
     */
    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        String content = new String(Files.readAllBytes(path));

        if (ext != null && path.toString().endsWith(ext) && text != null && content.contains(text)) {
            results.add(path.toAbsolutePath().toString());
        }
        return FileVisitResult.CONTINUE;
    }

    /**
     * Return root.
     * @return String.
     */
    public String getRoot() {
        return this.root;
    }

    /**
     * Return extension.
     * @return String.
     */
    public String getExt() {
        return this.ext;
    }
}