package kz.sanai.user.homework03;

import kz.sanai.user.homework03.beans.ChildBean;
import kz.sanai.user.homework03.beans.ParentBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Homework03Application {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(ParentBean.class, ChildBean.class);
            context.refresh();

            ParentBean parentBean = context.getBean("parent", ParentBean.class);
            ParentBean parentBean2 = context.getBean("parent", ParentBean.class);
            System.out.println(parentBean.getChildBean().getScopeTestNumber());
            System.out.println(parentBean2.getChildBean().getScopeTestNumber());
            System.out.println(parentBean.getChildBean().getScopeTestNumber() == parentBean2.getChildBean().getScopeTestNumber());
            System.out.println(parentBean.getChildBeanByLookup().getScopeTestNumber() == parentBean2.getChildBeanByLookup().getScopeTestNumber());

            ChildBean childBean = context.getBean("child", ChildBean.class);
            ChildBean childBean2 = context.getBean("child", ChildBean.class);
            System.out.println(childBean.getScopeTestNumber());
            System.out.println(childBean2.getScopeTestNumber());
            System.out.println(childBean.getScopeTestNumber() == childBean2.getScopeTestNumber());
        }
    }

}
