package com.ohgiraffers.policykorea.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class CKFinderConnectorController {

    @PostMapping("/board/ckfinder/connector")
    @ResponseBody
    public ResponseEntity<String> uploadImage(@RequestParam("upload") MultipartFile file) {
        String uploadDir = "./uploaded-images/";
        File uploadDirFile = new File(uploadDir);
        if (!uploadDirFile.exists()) {
            if (!uploadDirFile.mkdirs()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("{\"error\":{\"message\":\"Could not create upload directory.\"}}");
            }
        }

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        try {
            Path filePath = Paths.get(uploadDir + fileName);
            Files.write(filePath, file.getBytes());
            System.out.println("File uploaded successfully: " + filePath.toString());

            return ResponseEntity.ok("{\"uploaded\": true, \"url\":\"/images/" + fileName + "\"}");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"uploaded\": false, \"error\":{\"message\":\"Could not upload file. " + e.getMessage() + "\"}}");
        }
    }
}
