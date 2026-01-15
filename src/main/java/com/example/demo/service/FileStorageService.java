package com.example.demo.service;


import com.example.demo.dao.FileDBRepository;
import com.example.demo.model.FileDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Stream;

@Service
public class FileStorageService {

  @Autowired
  private FileDBRepository fileDBRepository;

  public FileDB store(MultipartFile file, FileDB fileDB) throws IOException {
    FileDB fileD=new FileDB();
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    //FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes() );
    //FileDB FileDBa = new FileDB(fileName, file.getContentType(), file.getBytes(),  );
    fileD.setName(fileName);
    fileD.setType(file.getContentType());
    fileD.setData(file.getBytes());
    fileD.setDescription(fileDB.getDescription());
    //fileDBRepository.save(fileDB);

    return fileDBRepository.save(fileD);
  }

  public FileDB storeUpdate(MultipartFile file, FileDB fileDB) throws IOException {
    FileDB fileD=new FileDB();
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    //FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes() );
    //FileDB FileDBa = new FileDB(fileName, file.getContentType(), file.getBytes(),  );
    fileD.setId(fileDB.getId());
    fileD.setName(fileName);
    fileD.setType(file.getContentType());
    fileD.setData(file.getBytes());
    fileD.setDescription(fileDB.getDescription());

    //fileDBRepository.save(fileDB);

    return fileDBRepository.save(fileD);
  }

  public FileDB getFile(Long id) {
    return fileDBRepository.findById(id).get();
  }
  public void deleteFile(Long id) {
   // Collection<FileDB> listeFille=fileDBRepository.findAll();

     fileDBRepository.deleteById(id);
  }




  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }
}
