package com.jd.cola.dto;


import java.util.Arrays;

/**
 * @author deer
 * @date 2021-12-14
 */
public class ResponseTest {
    public NonResponse testNonResponse(int i) {
        if (i > 1) {
            return NonResponse.ofFailure("7777", "dddddd");
        }
        return NonResponse.ofSuccess();
    }

    public SingleResponse<String> testSingleResponse(int i) {
        if (i > 1) {
            return SingleResponse.ofFailure("7777", "dddddd");
        }
        if (i < 1) {
            return SingleResponse.ofSuccess();
        }
        return SingleResponse.ofSuccess("hello");
    }

    public MultiResponse<String> testMultiResponse(int i) {
        if (i > 1) {
            return MultiResponse.ofFailure("7777", "dddddd");
        }
        if (i < 1) {
            return MultiResponse.ofSuccess();
        }
        return MultiResponse.ofSuccess(Arrays.asList("hello", "hello2"));
    }

    public PageResponse<String> testPageResponse(int i) {
        if (i > 1) {
            return PageResponse.ofFailure("7777", "dddddd");
        }
        if (i < 1) {
            return PageResponse.ofSuccess(1, 2);
        }
        return PageResponse.ofSuccess(Arrays.asList("hello", "hello2"), 1, 2, 3);
    }
}
