package com.backend.util;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.experimental.UtilityClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class CloudinaryUtil {
    public String uploadImage(Object file) throws IOException {
        var config = new HashMap<>();
        config.put("cloud_name", "dchefcs07");
        config.put("api_key", "366994417113435");
        config.put("api_secret", "pFv06ognVfXk6BM-NgTkjHkZZ8o");
        Cloudinary cloudinary = new Cloudinary(config);
        var uploadResult = cloudinary
                .uploader()
                .upload(file, ObjectUtils.emptyMap());
        return (String) uploadResult.get("url");
    }
}
