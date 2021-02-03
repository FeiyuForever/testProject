package com.feiyu.data.ocean.controller;

import com.feiyu.data.ocean.controller.base.BaseController;
import com.feiyu.data.ocean.controller.base.CodeUtils;
import com.feiyu.data.ocean.controller.base.ReponseEntity;
import com.feiyu.data.ocean.model.Post;
import com.feiyu.data.ocean.service.PostService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2019/12/8  14:43
 */
@RestController
@RequestMapping("/mapper")
public class UserController  extends BaseController {

    @Autowired
    private PostService postService;

    private  final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/postList",method = {RequestMethod.GET,RequestMethod.POST})
    public ReponseEntity findPost(){
        List<Post> postList = postService.findPostList();
        if(CollectionUtils.isNotEmpty(postList)){
            return makeReponse().data(postList);
        }else{
            return makeReponse().codeError(CodeUtils.ResposeCode.ERROR_401, "查询结果为空");
        }
    }

    /*@RequestMapping(value = "/infos",method = {RequestMethod.GET,RequestMethod.POST})
    public ReponseEntity findCompanyInfos(@RequestBody String params)throws Exception{
        if(StringUtils.isEmpty(params)){
            logger.error("params is null"+params);
            return makeReponse().codeError(CodeUtils.ResposeCode.ERROR_401, "参数params为空");
        }
        List<Company> personList = personService.findCompanyInfos(params);
        if(personList == null || personList.size() == 0){
            logger.error("personList is null"+personList);
            return makeReponse().codeError(CodeUtils.ResposeCode.ERROR_401, "查询结果为空");
        }
        return makeReponse().data(personList);
    }*/
}
