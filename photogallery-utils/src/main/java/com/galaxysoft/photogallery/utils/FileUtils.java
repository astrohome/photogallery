package com.galaxysoft.photogallery.utils;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Illia IZOTOV on 21/08/15.
 */
@Component
public class FileUtils {

    final PathMatcher matcher;

    @Value("${file.scan.directory}")
    private String galleriesPath;
    @Value("${file.scan.extension:.jpg}")
    private String extension;
    @Value("${file.thumbs.directory}")
    private String thumbsPath;
    @Value("${file.download.temp}")
    private String archivePath;
    @Value("${file.thumbs.watermark}")
    private String thumbsWatermark;
    @Value("${gallery.delta}")
    private Integer delta;

    @Log
    private Logger logger;

    public FileUtils() {
        matcher = FileSystems.getDefault().getPathMatcher("glob:**/*." + extension);
    }

    public Set<Path> searchGalleries() {
        Set<Path> dirs = new HashSet<>();
        searchDirectories(dirs, Paths.get(galleriesPath).toAbsolutePath());
        return dirs;
//        return dirs.parallelStream().filter(path -> {
//            final boolean[] hasImages = {false};
//            path.forEach(file -> {
//                if (!Files.isDirectory(file) && matcher.matches(file)) {
//                    hasImages[0] = true;
//                }
//            });
//            return hasImages[0];
//        }).collect(Collectors.toSet());
    }

    private void searchDirectories(Set<Path> galleries, Path start) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(start)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    searchDirectories(galleries, entry);
                    galleries.add(entry);
                }
            }
        } catch (IOException e) {
            logger.error(e);
        }
    }

}
