package com.stu.service;

import com.stu.exception.FileException;
import com.stu.property.FileProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * ClassName：FileServiceInterfaceImpl
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/1/10 11:58
 * @version 1.0.0
 */
@Service
public class FileService {

    private final Path fileStorageLocation;

    /**
     * MethodName: isCreateDictionary
     * Description:判断是否能够创建将要下载的文件目录
     *
     * @param fileProperties 文件的相应实体
     * @return bool
     * @author lhw
     * CreateTime 2020/1/10 12:49
     */

    @Autowired
    public FileService(FileProperties fileProperties) {
        this.fileStorageLocation = Paths.get(fileProperties.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    /**
     * MethodName: storeFile
     * Description:存储文件到系统
     * @author lhw
     * CreateTime 2020/1/10 13:02
     * @param file 文件
     * @return 文件名
     */

    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        // Check if the file's name contains invalid characters
        try {
            if (fileName.contains("..")) {
                throw new FileException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new FileException("Could not store file " + fileName + ". Please try again!",e);
        }
        return fileName;
    }

    /**
     * MethodName: loadFileAsResource
     * Description:加载文件
     * @author lhw
     * CreateTime 2020/1/10 13:03
     * @param fileName 文件名
     * @return 文件
     */

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()){
                return resource;
            }else {
                throw new FileException("File not found "+ fileName);
            }
        } catch (MalformedURLException e) {
            throw new FileException("File not found "+ fileName,e);
        }
    }
}
