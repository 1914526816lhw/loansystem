package com.stu.dto;

/**
 * ClassName：UploadFileResponse
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/1/10 11:44
 * @version 1.0.0
 */
public class UploadFileResponse {
    private String fileName;
    private String FileDownLoadUri;
    private String fileType;
    private String fileLoadAddress;
    private long size;
    public UploadFileResponse(String fileName, String FileDownLoadUri, String fileType, long size, String fileLoadAddress) {
        this.fileName = fileName;
        this.FileDownLoadUri = FileDownLoadUri;
        this.fileType = fileType;
        this.size = size;
        this.fileLoadAddress = fileLoadAddress;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownLoadUri() {
        return FileDownLoadUri;
    }

    public void setFileDownLoadUri(String FileDownLoadUri) {
        this.FileDownLoadUri = FileDownLoadUri;
    }

    public String getfileType() {
        return fileType;
    }

    public void setfileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getFileLoadAddress() {
        return fileLoadAddress;
    }

    public void setFileLoadAddress(String fileLoadAddress) {
        this.fileLoadAddress = fileLoadAddress;
    }

    @Override
    public String toString() {
        return "UploadFileResponse{" +
                "fileName='" + fileName + '\'' +
                ", FileDownLoadUri='" + FileDownLoadUri + '\'' +
                ", fileType='" + fileType + '\'' +
                ", size=" + size +
                '}';
    }
}
