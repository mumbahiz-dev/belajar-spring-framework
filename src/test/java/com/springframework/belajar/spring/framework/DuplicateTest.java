package com.springframework.belajar.spring.framework;

import com.springframework.belajar.spring.framework.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DuplicateTest {

    @Test
    void testDuplicate(){
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateBeanConfiguration.class);
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            context.getBean(Foo.class);
        });
    }

    @Test
    void getBean(){
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateBeanConfiguration.class);
        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);

        Assertions.assertNotSame(foo1, foo2);
    }
}
