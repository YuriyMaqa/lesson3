package guru.qa;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;


public class Junit5Tests {

    @BeforeAll
    static void inidb() {
        System.out.println("### BeaforeAll");
    }

    @BeforeEach
    void openYaPage() {
        System.out.println("###     BeaforeEach");
    //    Selenide.open("https://ya.ru");
    }

    @AfterEach
    void close() {
        System.out.println("###     AfterEach");
    //    WebDriverRunner.closeWindow();
    }

    @AfterAll
    static void closedb() {
        System.out.println("### AfterAll");
    }


    @Test
    void assertTest() {
        System.out.println("###         @Test 0");
        //...поиск новости
    }

    @Test
    void assertTest2() {
        System.out.println("###         @Test 1");
        //... поиск картинки
    }

    @Test
    void assertTest3() {
        System.out.println("###         @Test 2");
        //...поиск новости
    }

    @Test
    void assertTest4() {
        System.out.println("###         @Test 3");
        //... поиск картинки
    }
}
