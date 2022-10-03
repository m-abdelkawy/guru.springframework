package guru.springframework;

import guru.springframework.controllers.*;
import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"guru", "guru.springframework"})
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx= SpringApplication.run(DiDemoApplication.class, args);

        MyController controller = (MyController)ctx.getBean("myController");

        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);

        System.out.println(fakeDataSource.getUser());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getUrl());
        System.out.println("------------------------");
        FakeJmsBroker fakeJmsBroker = ctx.getBean(FakeJmsBroker.class);
        System.out.println(fakeJmsBroker.getUser());
        System.out.println(fakeJmsBroker.getPassword());
        System.out.println(fakeJmsBroker.getUrl());
    }

}
