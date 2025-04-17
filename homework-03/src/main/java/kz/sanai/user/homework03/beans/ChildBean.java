package kz.sanai.user.homework03.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("child")
@Scope("prototype")
public class ChildBean {
    private final int scopeTestNumber;
    private final static int range = 10000;
    public ChildBean() {
        scopeTestNumber = LocalDateTime.now().getNano() * (int)(Math.random() * range);
    }

    public int getScopeTestNumber() {
        return scopeTestNumber;
    }

}
