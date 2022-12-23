package me.nightletter.javareflectcommoncode.common.service;

import me.nightletter.javareflectcommoncode.common.code.CommonCodeAnnotation;
import me.nightletter.javareflectcommoncode.common.code.CommonCodeInterface;
import me.nightletter.javareflectcommoncode.common.dto.CodeResponse;
import me.nightletter.javareflectcommoncode.common.dto.CodesResponse;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AnnoCommonService implements CommonService{


    // TODO: 2022/12/23  이거 구현하기
    @Override
    public List<CodeResponse> findCommonCode(String codeGroupNm) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        Reflections reflections = new Reflections(PREFIX);

        List<Class<?>> findOne = reflections.getTypesAnnotatedWith(CommonCodeAnnotation.class).stream()
                .filter(o -> o.getSimpleName().equals(codeGroupNm))
                .collect(Collectors.toList());

        List<CodeResponse> result = new ArrayList<>();

        for (Class<?> item : findOne) {
            for (Object code : item.getEnumConstants()) {

                Method nm = item.getDeclaredMethod("nm");
                Method dc = item.getDeclaredMethod("dc");
                Object codeNm = nm.invoke(code);
                Object codeDc = dc.invoke(code);

                result.add(new CodeResponse(code.toString(), codeNm.toString(), codeDc.toString()));
            }
        }

        return result;
    }

    @Override
    public List<CodesResponse> findCommonCodes() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Reflections reflections = new Reflections(PREFIX);
        Set<Class<?>> codeGroups = reflections.getTypesAnnotatedWith(CommonCodeAnnotation.class);

        List<CodesResponse> result = new ArrayList<>();

        for (Class<?> codeGroup : codeGroups) {
            CodesResponse codesResponse = new CodesResponse(codeGroup.getSimpleName());

            for (Object enumConstant : codeGroup.getEnumConstants()) {
                Method nm = codeGroup.getDeclaredMethod("nm");
                Method dc = codeGroup.getDeclaredMethod("dc");
                Object codeNm = nm.invoke(enumConstant);
                Object codeDc = dc.invoke(enumConstant);

                codesResponse.getCodes().add(new CodeResponse(enumConstant.toString(), codeNm.toString(), codeDc.toString()));
            }

            result.add(codesResponse);
        }

        return result;
    }
}
