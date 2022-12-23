package me.nightletter.javareflectcommoncode.common.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CodesResponse {

    private String groupNm;
    private List<CodeResponse> codes = new ArrayList<>();

    public CodesResponse(String groupNm) {
        this.groupNm = groupNm;
    }
}
