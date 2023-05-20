package com.controller;

import com.Data1.Document;
import com.Data1.JsonFactory;
import com.Request.objectRequest;
import com.service.DocumentService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin
public class DocumentController {

    DocumentService documentService;
    JsonFactory jsonFactory;
    DocumentController() throws IOException {
        documentService=new DocumentService();
        jsonFactory=new JsonFactory();
    }
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        int status=documentService.updateDocument(file);
        return ResponseEntity.ok(jsonFactory.toJsonString(new objectRequest(status,documentService.getStatus(status))));
    }

    @GetMapping(value = "/download/{DocumentID}", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<Resource> downloadFile(@PathVariable int DocumentID) {

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=file.txt"); // 设置下载的文件名
        Resource fileResource= documentService.downloadFile(DocumentID);
        // 返回文件资源作为响应
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(fileResource);

    }
    @PostMapping("/queryall")
    public ResponseEntity<List<Document>> QueryAll() {
        return ResponseEntity.ok(documentService.QueryAll());
    }

}
