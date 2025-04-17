package kz.sanai.user.homework03.beans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("parent")
@Scope("singleton")
public class ParentBean {

    // этот пример в лоб догадался сам
    public ChildBean getChildBean() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(ChildBean.class);
            context.refresh();
            return context.getBean("child", ChildBean.class);
        }
    }

    //гугл помог
    @Lookup
    public ChildBean getChildBeanByLookup() {
        return null;
    }
}
