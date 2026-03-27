package com.xworkz.pcfile.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class FileDto {
    private String name;
    private String filePath;
    private MultipartFile file;

}
