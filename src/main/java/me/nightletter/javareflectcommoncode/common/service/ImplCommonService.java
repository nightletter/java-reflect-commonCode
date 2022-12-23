package me.nightletter.javareflectcommoncode.common.service;

import me.nightletter.javareflectcommoncode.common.code.CommonCodeInterface;
import me.nightletter.javareflectcommoncode.common.dto.CodeResponse;
import me.nightletter.javareflectcommoncode.common.dto.CodesResponse;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ImplCommonService implements CommonService{

    @Override
    public List<CodeResponse> findCommonCode(String codeGroupNm) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {

        Class<?> aClass = Class.forName(PREFIX + codeGroupNm);
        Object[] codeConstants = aClass.getEnumConstants();
        List<CodeResponse> result = new ArrayList<>();

        for (Object code : codeConstants) {
            Method nm = aClass.getDeclaredMethod("nm");
            Method dc = aClass.getDeclaredMethod("dc");
            Object codeNm = nm.invoke(code);
            Object codeDc = dc.invoke(code);

            result.add(new CodeResponse(code.toString() ,codeNm.toString(), codeDc.toString()));
        }

        return result;
    }

    @Override
    public List<CodesResponse> findCommonCodes() throws  NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Reflections reflections = new Reflections(PREFIX);
        Set<Class<? extends CommonCodeInterface>> codeGroups = reflections.getSubTypesOf(CommonCodeInterface.class);

        List<CodesResponse> codes = new ArrayList<>();

        for (Class<? extends CommonCodeInterface> codeGroup : codeGroups) {
            CodesResponse codesResponse = new CodesResponse(codeGroup.getSimpleName());

            for (Object enumConstant : codeGroup.getEnumConstants()) {
                Method nm = codeGroup.getDeclaredMethod("nm");
                Method dc = codeGroup.getDeclaredMethod("dc");
                Object codeNm = nm.invoke(enumConstant);
                Object codeDc = dc.invoke(enumConstant);

                codesResponse.getCodes().add(new CodeResponse(enumConstant.toString(), codeNm.toString(), codeDc.toString()));
            }

            codes.add(codesResponse);
        }

        return codes;
    }
}
