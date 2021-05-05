package com.wangyang.bioinfo;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @author wangyang
 * @date 2021/5/3
 */
@SpringBootTest
public class TestHttp {
    @Test
    public void test() throws IOException {
        Content content = Request.Get("http://bioinfo.online")
                .execute().returnContent();
        System.out.println();
    }
}
