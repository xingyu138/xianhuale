package cn.springbootxianhualemaster.controller;


import cn.springbootxianhualemaster.services.IFileService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/manager/product")
public class ProductManagerController {

    @Autowired
    private IFileService iFileService;

    @RequestMapping("/upload.htm")
    @ResponseBody
    public ServerResponse upload(@RequestParam(value = "upload_file",required = false)
                                         MultipartFile file, HttpServletRequest request){
      
		String path = request.getSession().getServletContext().getRealPath("upload");
		String targetFileName = iFileService.upload(file,path);
		String url = "http://129.204.22.202/leo/img/"+targetFileName;

		Map fileMap = Maps.newHashMap();
		fileMap.put("uri",targetFileName);
		fileMap.put("url",url);
		return ServerResponse.createBySuccess(fileMap);        
    }
}

