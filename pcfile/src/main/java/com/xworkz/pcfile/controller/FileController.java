package com.xworkz.pcfile.controller;

import com.xworkz.pcfile.dto.FileDto;
import com.xworkz.pcfile.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/")
public class FileController {
    @Autowired
    FileService fileService;
    public FileController(){
        System.out.println("controller");
    }
    @PostMapping("index")
    public String index(@ModelAttribute FileDto fileDto, Model model) throws IOException {
        System.out.println("Hiii");
        System.out.println(fileDto);
        MultipartFile file = fileDto.getFile();
        byte [] bytes = file.getBytes();
        Path path = Paths.get("J:\\newfileProject\\" + file.getOriginalFilename() + System.currentTimeMillis() + ".pdf");
        System.out.println(path);
        Files.write(path,bytes);

        fileDto.setFilePath(path.toString());
        boolean uploadFile = fileService.uploadFile(fileDto);
        System.out.println("now file is added");

        if (uploadFile){
            model.addAttribute("file","Invalid File");
        }

        return "index";
    }
}
