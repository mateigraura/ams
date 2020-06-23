package com.presentation.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PackagePath {
    public static Path get(String packageName) {
        return Paths.get("", "src", "main", "java", "com", packageName).toAbsolutePath();
    }
}
