package com.example.demo.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class FileHandlingController {

    String path = System.getProperty("user.dir") + "\\Uploads";

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUplaod(@RequestParam("file") MultipartFile file) throws IOException{
        File convertFile = new File(path + file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convertFile);
        fos.write(file.getBytes());
        fos.close();

        return "File is uploaded successfully";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<Object> fileDownload() throws IOException{
        String fileName = path + "\\boy.png";
        File file = new File(fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders header = new HttpHeaders();

        header.add("Content-disposition", String.format("attachment: filename=\"%s\"", file.getName()));
        header.add("Cache-Control","no-cache, no-store, must-revalidate");
        header.add("pragma", "no-cache");
        header.add("Expires", "0");

        ResponseEntity<Object> entity = ResponseEntity.ok().headers(header).contentLength(file.length()).contentType(
            MediaType.parseMediaType("application/txt")).body(resource);

        return entity;
    }
}
