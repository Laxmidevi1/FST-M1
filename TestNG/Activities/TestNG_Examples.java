package examples;

import org.testng.annotations.BeforeClass;

public class TestNG_Examples {

    @BeforeClass
    public void setUpforClass(){System.out.println("Before every test method");}
}
