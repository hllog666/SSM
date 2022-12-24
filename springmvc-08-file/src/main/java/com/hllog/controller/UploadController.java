package com.hllog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class UploadController {
    @RequestMapping("/upload")
    public String upload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        String filename = file.getOriginalFilename();
        if ("".equals(filename)) {
            return "redirect:/index.jsp";
        }
        String path = request.getServletPath();
        System.out.println("===================" + path);
        File realPath = new File(path);
        System.out.println("===================" + realPath);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        InputStream inputStream = file.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(realPath, filename));
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);
            fileOutputStream.flush();
        }
        fileOutputStream.close();
        inputStream.close();
        return "redirect:/index.jsp";
    }

    @RequestMapping("/upload2")
    public String upload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getServletPath();
        File realPath = new File(path);
        System.out.println("===================" + realPath);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
        return "redirect:/index.jsp";
    }

    @RequestMapping("/test")
    @ResponseBody
    public void test(HttpServletRequest request) {
        System.out.println(request.getPathInfo());
        System.out.println(request.getContextPath());
        System.out.println(request.getRequestURI());
        System.out.println(request.getPathTranslated());
        System.out.println(request.getRequestURL());
        System.out.println(request.getServletPath());
    }

    @RequestMapping("/myupload")
    public String myupload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        String filename = file.getOriginalFilename();
        if ("".equals(filename)) {
            return "redirect:/index.jsp";
        }
        File realPath = new File("E:\\upload");
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        InputStream inputStream = file.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(realPath, filename));
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);
            fileOutputStream.flush();
        }
        fileOutputStream.close();
        inputStream.close();
        return "redirect:/index.jsp";
    }

    @RequestMapping("/myupload2")
    public String myupload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        File realPath = new File("E:\\upload");
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
        return "redirect:/index.jsp";
    }

    @RequestMapping("/download")
    @ResponseBody
    public String download(HttpServletResponse response, HttpServletRequest request) throws Exception {
        String path = "E:\\upload";
        String fileName = "C++_Primer_4th_习题答案.pdf";
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multi/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName + URLEncoder.encode(fileName,
                "UTF-8"));
        File file = new File(path, fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int index = 0;
        while ((index = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, index);
            outputStream.flush();
        }
        outputStream.close();
        fileInputStream.close();
        return null;
    }
}
