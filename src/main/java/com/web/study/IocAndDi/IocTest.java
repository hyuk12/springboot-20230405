package com.web.study.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class IocTest {

    @Autowired
    @Qualifier("t1")
    private Test test;

//    public IocTest(Test test) {
//        this.test = test;
//    }

    public void run() {
        test.printTest();
        System.out.println("IocTest Output");
    }
}