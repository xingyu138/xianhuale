package cn.springbootxianhualemaster.services;

import cn.springbootxianhualemaster.util.FTPUtil;

import com.google.common.collect.Lists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service("iFileService")
public class FileServiceImpl implements IFileService {
	private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    public String upload(MultipartFile file, String path){
        String fileName = file.getOriginalFilename();
        //扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        logger.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}",fileName,path,uploadFileName);

        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true); //开启文件夹的写权限
            fileDir.mkdirs();
        }
        File targetFile = new File(path,uploadFileName);

        try {
            //文件上传tomcat
            file.transferTo(targetFile);
            //上传到ftp服务器上
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //从tomcat目录中删除，用ftp服务器保存图片
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常",e);
            return null;
        }
        return targetFile.getName();
    }

	

}
