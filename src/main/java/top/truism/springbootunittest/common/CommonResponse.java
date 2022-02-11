package top.truism.springbootunittest.common;

import lombok.Data;

@Data
public class CommonResponse<T> {

    private int code;

    private String message;

    private T data;

    public static <T> CommonResponse success(int code, String message, T data) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(code);
        commonResponse.setMessage(message);
        commonResponse.setData(data);
        return commonResponse;
    }

    public static CommonResponse fail(int code, String message) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(code);
        commonResponse.setMessage(message);
        return commonResponse;
    }

}
