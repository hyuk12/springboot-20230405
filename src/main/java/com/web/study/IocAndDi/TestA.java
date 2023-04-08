package com.web.study.IocAndDi;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("t1")
public class TestA implements Test {

    @Override
    public void printTest() {
        System.out.println("TestA Class!!!");
    }
}