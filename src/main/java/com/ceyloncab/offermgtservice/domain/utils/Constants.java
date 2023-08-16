package com.ceyloncab.offermgtservice.domain.utils;

import lombok.Getter;

public class Constants {
    public static final String UNHANDLED_ERROR_CODE = "OTP3000";
    @Getter
    public enum ResponseData {
        CREATE_SUCCESS("OTP1000", "Success","200"),
        QUERY_SUCCESS("OTP1001", "Verified","200"),
        COMMON_FAIL("OTP2000", "Failed","400"),
        ADMIN_NOT_FOUND("UMS2002", "Admin not found","400"),
        INTERNAL_SERVER_ERROR("OTP3001", "Internal Server Error","500");

        private String code;
        private String message;
        private String responseCode;

        ResponseData(String code, String message, String responseCode) {
            this.code = code;
            this.message = message;
            this.responseCode= responseCode;
        }
    }
}
