package com.example.demo.controller;
import com.example.demo.DemoApplication;
import com.example.demo.dto.Person;
import com.example.demo.sao.MySao;
import com.example.demo.service.MyService;
import com.example.demo.service.impl.MyServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;
/**
 * @Author huct
 * @Date 2019/7/20 - 9:01
 */
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@RunWith(PowerMockRunner.class)
@PowerMockIgnore(value = { "javax.management.*", "javax.net.ssl.*", "javax.net.SocketFactory" })
@PrepareForTest({ MyServiceImpl.class })
@SpringBootTest(classes = DemoApplication.class)
public class MyControllerTest {
    @Autowired
    MyController myController;


    @Mock
    MySao mySao;

    @InjectMocks
    @Autowired
    //@InjectMocks只能放在具体类上，不能放接口
    //要用@Autowired让spring使用这个加了@InjectMocks的myService,
            // 否则myController会注入另外的myService，导致mock不生效
    MyServiceImpl myService;

    @Before
    public void initMocks() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPer() throws Exception {
        when(mySao.findPer()).thenReturn(new Person("huctmock"));
        System.out.println(myController.getPer());
        Person pr = myController.getPer();
        Person person = new Person("huctmock");
        Assert.assertEquals(person,pr);
        System.out.println("===myService====="+myService.queryPer());

        /**
         *mock静态方法
         */
        PowerMockito.mockStatic(MyServiceImpl.class);
        when(MyServiceImpl.getStr()).thenReturn("mockstatic");
        System.out.println(myController.getstrf());

        /**
         * mock私有方法
         */
        MyServiceImpl myServicePrivteMock = PowerMockito.spy(myService);
        PowerMockito.when(myServicePrivteMock, "getPrivate").thenReturn("mockPrivate");
        System.out.println(myServicePrivteMock.testPri());//公共方法testPri()调用了自己的私有方法getPrivate()
        System.out.println(myService.testPri());
    }
}

