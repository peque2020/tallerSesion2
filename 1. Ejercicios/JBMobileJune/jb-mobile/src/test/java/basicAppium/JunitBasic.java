package basicAppium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JunitBasic {

    @Before
    public void beforeTest(){
        //accion antes de una prueba
        //setup - initilize
        System.out.println("beforeTest");
    }

    @After
    public void afterTest(){
        //accion despues de una prueba
        //cleanup - teardown
        System.out.println("afterTest");
    }

    @Test
    public void verifySomething(){
        System.out.println("test1");
    }

    @Test
    public void verifySomething2(){
        System.out.println("test2");
    }

}
