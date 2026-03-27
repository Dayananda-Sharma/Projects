package com.xworkz.pcfile.service;

import com.xworkz.pcfile.dto.FileDto;
import com.xworkz.pcfile.entity.FileEntity;
import com.xworkz.pcfile.repo.FileRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService{
    @Autowired
    FileRepo fileRepo;
    @Override
    public boolean uploadFile(FileDto fileDto) {
        System.out.println("service"+fileDto);
        FileEntity fileEntity=new FileEntity();
        BeanUtils.copyProperties(fileDto,fileEntity);
        boolean uploaded = fileRepo.uploadFileRepo(fileEntity);

        return true;
    }
}
