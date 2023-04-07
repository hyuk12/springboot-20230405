package com.web.study.IocAndDi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class IoCTestController {

    private final IocTest iocTest;
    private final IocTest2 iocTest2;

    @GetMapping("/ioc/test")
    public Object test() {
        iocTest.run();
        iocTest2.run();
        return null;
    }
}
