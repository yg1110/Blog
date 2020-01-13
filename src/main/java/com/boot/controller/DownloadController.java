package com.boot.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DownloadController {
    @RequestMapping("/download")
    @ResponseBody
    public byte[] downProcess(HttpServletResponse response,
        @RequestParam String filename) throws IOException{
        File file = new File("/Users/jeong-yeong-gil/Documents/stswork/Blog/src/main/resources/static/image/" + filename);
        byte[] bytes = FileCopyUtils.copyToByteArray(file);
        
        String fn = new String(file.getName().getBytes(), "iso_8859_1");
        
        response.setHeader("Content-Disposition",
                "attachment;filename=\"" + fn + "\"");
        response.setContentLength(bytes.length);
        return bytes;
    }
}