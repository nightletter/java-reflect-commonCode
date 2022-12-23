package me.nightletter.javareflectcommoncode.common.service;

import me.nightletter.javareflectcommoncode.common.dto.CodeResponse;
import me.nightletter.javareflectcommoncode.common.dto.CodesResponse;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class AnnoCommonService implements CommonService{

    @Override
    public List<CodeResponse> findCommonCode(String codeGroupNm) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<CodesResponse> findCommonCodes() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return null;
    }
}
