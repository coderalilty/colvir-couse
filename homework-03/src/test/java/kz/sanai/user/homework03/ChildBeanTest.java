package kz.sanai.user.homework03;

import kz.sanai.user.homework03.beans.ChildBean;
import kz.sanai.user.homework03.beans.ParentBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ChildBeanTest {
    @Test
    public void singletonBeanTest() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(ParentBean.class, ChildBean.class);
            context.refresh();

            ChildBean childBean = context.getBean("child", ChildBean.class);
            TimeUnit.SECONDS.sleep(1);
            ChildBean childBean2 = context.getBean("child", ChildBean.class);
            assertNotEquals(childBean.getScopeTestNumber() ,childBean2.getScopeTestNumber());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
