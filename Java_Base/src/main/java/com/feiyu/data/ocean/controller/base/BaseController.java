package com.feiyu.data.ocean.controller.base;

/**
 * @Author xzhou.James
 * @Date 2019/12/8  14:44
 */
public class BaseController<T> {

    public ReponseEntity makeReponse(){
        ReponseEntity<T> reponseEntity = new ReponseEntity<T>();
        return reponseEntity;
    }

}
