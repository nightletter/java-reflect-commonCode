package me.nightletter.javareflectcommoncode.common.service;

import me.nightletter.javareflectcommoncode.common.dto.CodeResponse;
import me.nightletter.javareflectcommoncode.common.dto.CodesResponse;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public interface CommonService {

    String PREFIX = "me.nightletter.javareflectcommoncode.common.code.";

    List<CodeResponse> findCommonCode(String codeGroupNm) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException;
    List<CodesResponse> findCommonCodes() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
