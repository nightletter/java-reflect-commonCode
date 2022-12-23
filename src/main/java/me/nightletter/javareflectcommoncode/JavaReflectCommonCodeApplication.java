package me.nightletter.javareflectcommoncode;

import me.nightletter.javareflectcommoncode.common.service.AnnoCommonService;
import me.nightletter.javareflectcommoncode.common.service.CommonService;
import me.nightletter.javareflectcommoncode.common.service.ImplCommonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaReflectCommonCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaReflectCommonCodeApplication.class, args);
    }

    @Bean
    public CommonService commonService() {
        return new AnnoCommonService();
//        return new ImplCommonService();
    }
}
