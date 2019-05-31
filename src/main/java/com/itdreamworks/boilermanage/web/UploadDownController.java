package com.itdreamworks.boilermanage.web;

import com.itdreamworks.boilermanage.util.Result;
import com.itdreamworks.boilermanage.util.ResultGenerator;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 用户文件上传下载
 */
@RestController
@RequestMapping("/upload")
public class UploadDownController {

    /**
     * 文件上传
     * @param picture
     * @param request
     * @return
     */
    @RequestMapping("/uploadFile")
    public Result upload(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) throws FileNotFoundException {
        String orgId = request.getParameter("orgId");
        String fileType = request.getParameter("type");
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(!path.exists()) path = new File("");
        System.out.println("path:"+path.getAbsolutePath());

        //如果上传目录为/static/images/upload/，则可以如下获取：
        File upload = new File(path.getAbsolutePath(),"static/images/upload/"+orgId+"/");
        if(!upload.exists()) upload.mkdirs();
        System.out.println("upload url:"+upload.getAbsolutePath());
        //获取文件在服务器的储存位置
        //String path = request.getAbsolutePath();
        File filePath = new File(upload.getAbsolutePath());
        System.out.println("文件的保存路径：" + upload.getAbsolutePath());
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称(包含格式)
        String originalFileName = picture.getOriginalFilename();
        System.out.println("原始文件名称：" + originalFileName);

        /*//获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型：" + type);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));*/

        //设置文件新名称: 当前时间+文件名称（不包含格式）
        String fileName = fileType +".jpg";
        System.out.println("新文件名称：" + fileName);

        //在指定路径下创建一个文件
        File targetFile = new File(filePath, fileName);

        //将文件保存到服务器指定位置
        try {
            picture.transferTo(targetFile);
            System.out.println("上传成功");
            //将文件在服务器的存储路径返回
            return ResultGenerator.genSuccessResult(200,"success","/images/upload/"+orgId +"/" + fileName);
        } catch (IOException e) {
            System.out.println("上传失败");
            e.printStackTrace();
            return ResultGenerator.genFailResult( 201,"上传失败");
        }
    }
    // 删除文件
    @PostMapping("/deleteFile")
    public Result deleteFile(@RequestParam("path") String path)throws FileNotFoundException {
        File file = null;
        try {
            file = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(!file.exists()) file = new File("");
        System.out.println("path:"+file.getAbsolutePath());

        //如果上传目录为/static/images/upload/，则可以如下获取：
        File delete = new File(file.getAbsolutePath(),"static/" + path);
        if (delete.exists()) {
            if (delete.delete()) {
               return ResultGenerator.genSuccessResult();
            } else {
                return ResultGenerator.genFailResult("删除失败");
            }
        } else {
            return ResultGenerator.genFailResult("文件不存在");
        }
    }

}
