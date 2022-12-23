package me.nightletter.javareflectcommoncode.common.service;

import me.nightletter.javareflectcommoncode.common.dto.CodeResponse;
import me.nightletter.javareflectcommoncode.common.dto.CodesResponse;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public interface CommonService {

    final String PREFIX = "me.nightletter.javareflectcommoncode.common.code.";

    public List<CodeResponse> findCommonCode(String codeGroupNm) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException;
    public List<CodesResponse> findCommonCodes() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
