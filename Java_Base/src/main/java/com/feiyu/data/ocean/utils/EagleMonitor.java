package com.feiyu.data.ocean.utils;


import org.springframework.stereotype.Component;

@Component
public class EagleMonitor {

 /*  private static final Logger log = LoggerFactory.getLogger(EnterpriseApplication.class);

    @Value("${spring.wind.eagle.config}")
    private String eagleConfig;


    public void execute(){
        try{
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            File file = resolver.getResource(eagleConfig).getFile();
            if(file.exists()) {
                log.info(file.getAbsolutePath());
                CustomPerfDataListener customPerfDataListener = new CustomPerfDataListener();
                boolean success = EagleService.start(file.getAbsolutePath(), customPerfDataListener);
                if (true == success && true == EagleService.isStart()) {
                    //EagleService.sendDebug("test", "企业库(CORP)监控程序");
                    //EagleService.sendDebug(501, 'F', "企业库(CORP)监控程序", "拉包监控帐户,认证失败");
                    log.info("Hello Eagle with sendInfo!");
                }
                else {
                    log.info("Start Eagle Failed!");
                }
            } else {
                log.info("NOT EXISTS:" + file.getAbsolutePath());
            }
        }catch(Exception exp){
            log.error("exp",exp);
        }
    }*/
}
