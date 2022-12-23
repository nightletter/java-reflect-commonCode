package me.nightletter.javareflectcommoncode.common;

import lombok.RequiredArgsConstructor;
import me.nightletter.javareflectcommoncode.common.service.CommonService;
import me.nightletter.javareflectcommoncode.common.service.ImplCommonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/common")
public class CommonRestController {

    private final CommonService commonService;

    @GetMapping("/code")
    public ResponseEntity getCommonCode(String cdGrNm) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return ResponseEntity.ok(commonService.findCommonCode(cdGrNm));
    }

    @GetMapping("/codes")
    public ResponseEntity getCommonCodes() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return ResponseEntity.ok(commonService.findCommonCodes());
    }
}
