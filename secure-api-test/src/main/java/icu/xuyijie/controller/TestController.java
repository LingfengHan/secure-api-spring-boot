package icu.xuyijie.controller;

import icu.xuyijie.entity.ResultEntity;
import icu.xuyijie.secureapi.annotation.DecryptApi;
import icu.xuyijie.secureapi.annotation.DecryptParam;
import icu.xuyijie.secureapi.annotation.EncryptApi;
import org.springframework.web.bind.annotation.*;

/**
 * @author 徐一杰
 * @date 2024/6/18 19:22
 * @description
 */
@RestController
@RequestMapping("secureApiTest")
@EncryptApi
@DecryptApi
public class TestController {
    @RequestMapping("/testParam")
    public void testParam(@RequestHeader(required = false) String a, String id, @DecryptParam(name = "name", defaultValue = "徐一杰") String name) {
        System.out.println(a);
        System.out.println(id);
        System.out.println(name);
    }

    @RequestMapping("/testResponse")
    public ResultEntity<String> testResponse() {
        return ResultEntity.success("哈哈哈");
    }

    @RequestMapping("/testRequest")
    public ResultEntity<String> testRequest(@RequestHeader String a, @RequestBody ResultEntity<String> resultEntity) {
        System.out.println("请求头正常显示：" + a);
        System.out.println(resultEntity);
        return ResultEntity.success("嘿嘿嘿");
    }
}
