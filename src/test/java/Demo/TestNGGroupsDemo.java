package Demo;

import org.testng.annotations.Test;

@Test(groups = {"AllClassTests"})
public class TestNGGroupsDemo {

    @Test(groups ={"sanity"} )
    public void test1(){
        System.out.println("this is test 1 ");
    }
//    @Test(groups ={"sanity", "smoke"} )

    @Test(groups ={"window.regression"} )
    public void test2(){
        System.out.println("this is test 2 ");
    }

//    @Test(groups = {"sanity","regression"})
    @Test(groups ={"linux.regression"} )

    public void test3(){
        System.out.println("this is test 3 ");
    }

    @Test
    public void test4(){
        System.out.println("this is test 4 ");
    }
}
