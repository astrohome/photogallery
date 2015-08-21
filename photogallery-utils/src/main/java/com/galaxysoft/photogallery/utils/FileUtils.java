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

    DirectoryStream.Filter<Path> imagesFilter = new DirectoryStream.Filter<Path>() {
        @Override
        public boolean accept(Path file) throws IOException {
            final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*." + extension);
            return (!Files.isDirectory(file) && matcher.matches(file));
        }
    };
//    DirectoryStream.Filter<Path> directoryFilter = new DirectoryStream.Filter<Path>() {
//        @Override
//        public boolean accept(Path file) throws IOException {
//            if (Files.isDirectory(file)) {
//                return (findImages(file.getFileName().toString()).size() > 0);
//            }
//            return false;
//        }
//    };

    @Value("${file.scan.directory}")
    private String galleriesPath;
    @Value("${file.scan.extension}")
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

    public Set<String> searchGalleries() {
        Set<Path> dirs = new HashSet<>();
        searchDirectories(dirs, Paths.get(galleriesPath));
        return null;
    }

    private void searchDirectories(Set<Path> galleries, Path start) {
        try {
            Files.newDirectoryStream(start).forEach(x -> x.forEach(path -> {
                if (Files.isDirectory(path)) {
                    searchDirectories(galleries, path);
                } else {
                    galleries.add(path);
                }
            }));
        } catch (IOException e) {
            logger.error(e);
        }
    }

}
