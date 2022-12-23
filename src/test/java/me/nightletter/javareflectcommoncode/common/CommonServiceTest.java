package me.nightletter.javareflectcommoncode.common;

import me.nightletter.javareflectcommoncode.common.code.CommonCodeAnnotation;
import me.nightletter.javareflectcommoncode.common.code.MusicGenreCode;
import me.nightletter.javareflectcommoncode.common.code.PaymentTypeCode;
import me.nightletter.javareflectcommoncode.common.dto.CodeResponse;
import me.nightletter.javareflectcommoncode.common.dto.CodesResponse;
import me.nightletter.javareflectcommoncode.common.service.CommonService;
import me.nightletter.javareflectcommoncode.common.service.ImplCommonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

@SpringBootTest
class CommonServiceTest {

    @Autowired
    CommonService commonService;

    private final String exParam = "MusicGenreCode";

    @Test
    void commonCodeTest() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        List<CodeResponse> commonCode = commonService.findCommonCode(exParam);
        int length = MusicGenreCode.values().length;

        Assertions.assertEquals(commonCode.size(), length);
    }

    @Test
    void commonCodesTest() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        int responseCodeSize = 0;

        for (CodesResponse commonCode : commonService.findCommonCodes()) {
            responseCodeSize += commonCode.getCodes().size();
        }

        int length = MusicGenreCode.values().length + PaymentTypeCode.values().length;

        Assertions.assertEquals(responseCodeSize, length);
    }
}
