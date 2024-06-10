package Listeners;


import junit.framework.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(TestNGListeners.class)
public class TestNGListenerDemo {

    @Test
    public void test1(){

        System.out.println("i am inside test1");
    }

    @Test
    public void test2(){

        System.out.println("i am inside test2");
        Assert.assertTrue(false);
    }

    @Test
    public void test3(){

        System.out.println("i am inside test3");
        throw new SkipException("this test is skipped");
    }

    @Test
    public void test4(){

        System.out.println("i am inside test4");
    }
}
