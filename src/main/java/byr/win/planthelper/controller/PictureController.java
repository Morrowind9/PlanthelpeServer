package byr.win.planthelper.controller;

import lombok.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.ClassUtils;

import java.io.*;
import java.net.URLDecoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PictureController {
//    @Value("${picture.location}")
//    private String location;

    @PostMapping("/picRecognition")
    public String picRecognition(HttpServletRequest request, MultipartFile file) throws UnsupportedEncodingException {
        String fileName = file.getOriginalFilename();
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if(!fileType.equals(".jpg"))
            return null;
        String newFileName = UUID.randomUUID()+fileType;
        String filePath = "D:/Win/pics"  + "/" + newFileName;

        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdirs();
        }
        try {
            file.transferTo(file1);
            String[] args1=new String[]{"python","D:\\pythonRepository\\1\\predict.py", "-p", filePath};
            Process pr = Runtime.getRuntime().exec(args1);

            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line, res = null;
            while ((line = in.readLine()) != null) {
                res = line;
            }
            in.close();
            int exitVal = pr.waitFor();
            file1.delete();
            //若.py运行出错则返回null
            if(exitVal != 0)
                return null;
            return res;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
