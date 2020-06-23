package com.assets.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AssetsPath {
    public static Path getAbsolute(String fileName) {
        return Paths.get("", "src", "main", "java", "com", "assets", fileName).toAbsolutePath();
    }
}
