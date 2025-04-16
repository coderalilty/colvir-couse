package kz.sanai.user.homework03.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("parent")
@Scope("singleton")
public class ParentBean {
    private final ChildBean childBean;

    public ParentBean(ChildBean childBean) {
        this.childBean = childBean;
    }

    public ChildBean getChildBean() {
        return childBean;
    }
}
