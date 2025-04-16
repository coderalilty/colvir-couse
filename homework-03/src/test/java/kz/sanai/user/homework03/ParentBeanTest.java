package kz.sanai.user.homework03;

import kz.sanai.user.homework03.beans.ChildBean;
import kz.sanai.user.homework03.beans.ParentBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParentBeanTest {

    @Test
    public void singletonBeanTest() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(ParentBean.class, ChildBean.class);
            context.refresh();
            ParentBean parentBean = context.getBean("parent", ParentBean.class);
            TimeUnit.SECONDS.sleep(1);
            ParentBean parentBean2 = context.getBean("parent", ParentBean.class);
            assertEquals(parentBean.getChildBean().getScopeTestNumber() ,parentBean2.getChildBean().getScopeTestNumber());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
