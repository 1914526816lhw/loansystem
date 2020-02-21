package com.stu.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName：FileProperties
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/1/10 11:30
 * @version 1.0.0
 */

@ConfigurationProperties(prefix = "file")
public class FileProperties {
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
