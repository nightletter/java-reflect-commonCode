package me.nightletter.javareflectcommoncode.common.dto;

import lombok.Data;

@Data
public class CodeResponse  {

    private String code;
    private String codeNm;
    private String codeDc;

    public CodeResponse(String code, String codeNm, String codeDc) {
        this.code = code;
        this.codeNm = codeNm;
        this.codeDc = codeDc;
    }
}
