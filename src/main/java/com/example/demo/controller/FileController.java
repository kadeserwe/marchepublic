package com.example.demo.controller;


import com.example.demo.dao.FileDBRepository;
import com.example.demo.message.ResponseFile;
import com.example.demo.message.ResponseMessage;
import com.example.demo.model.FileDB;
import com.example.demo.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

//@Controller
//@CrossOrigin("http://localhost:9087")
@RestController
@RequestMapping("/api")
public class FileController {
  @Autowired
  private FileDBRepository fileDBRepository;
  @Autowired
  private FileStorageService storageService;


  @PostMapping("/upload")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file" ) MultipartFile file, FileDB fileDB) {
    String message = "";
    try {
      storageService.store(file, fileDB);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }

  @PutMapping("/upload")
  public ResponseEntity<ResponseMessage> uploadFileUpdate(@RequestParam("file" ) MultipartFile file, FileDB fileDB) {

    String message = "";
    try {

      storageService.storeUpdate(file, fileDB);

      message = "Update successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }

  @GetMapping("/files")
  public ResponseEntity<List<ResponseFile>> getListFiles() {
    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
              .fromCurrentContextPath()
              .path("/api/files/")
              .path(dbFile.getId().toString())
              .toUriString();
         /* .fromCurrentContextPath()
          .path("/files/")
          .path(dbFile.getId().toString())
          .toUriString();
*/
      return new ResponseFile(
          dbFile.getName(),
          fileDownloadUri,
          dbFile.getType(),
          dbFile.getData().length,
          dbFile.getDescription());
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(files);
  }

  @GetMapping("/files/{id}")
  public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
    FileDB fileDB = storageService.getFile(id);

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB.getData());
  }

  @DeleteMapping("/filles/{id}")
  public ResponseEntity<ResponseMessage> deletetFile(@PathVariable Long id) {

     storageService.deleteFile(id);

   String message = "Update successfully: " ;
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
  }
}
