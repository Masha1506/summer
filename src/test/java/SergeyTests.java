import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Screenshots.takeScreenShot;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.source;
import static com.codeborne.selenide.WebDriverRunner.url;


public class SergeyTests {
    @Test
    void test01_open() {
        open("https://ya.ru");
    }

    @Test
    void test02_sleep() {
        open("https://ya.ru");
        sleep(5000);
    }

    @Test
    void test03_SelenideElement() {
        open("http://92.51.36.108:7777/top.academy");
        sleep(5000);
        $(byText("Page tatyana.naumova")).should(exist);
    }

    @Test
    void test04_CSS_selector() {
        open("https://ya.ru");
        sleep(5000);
        $("[name=text]").should(exist);
        $("[name=text]").setValue("top academy");
        $("[name=text]").pressEnter();
        $("[id=search-result]").should(text("Компьютерная Академия"));
    }

    @Test
    void test05_Alfabank()  {
        open("https://alfabank.ru/");
        sleep(5000);
        $(byText("Вклады")).should(exist);
        $(byText("Вклады")).click();
        $("body").should(text("Счета и вклады"));
    }

    @Test
    void test06_println() {
        System.out.println("Hello World!");
        System.out.println("Привет, мир!");
    }

    @Test
    void test07_println(){
        open("https://ya.ru");
        sleep(5000);
        $("[name=text]").should(exist);
        $("[name=text]").setValue("top academy");
        $("[name=text]").pressEnter();
        sleep(5000);

        String pngFileName = screenshot("my_new_screenshot");
        File screenshot_file = takeScreenShot($("[id=search-result]"));

        System.out.println("HTML-код страницы:" + source());
        System.out.println("URL страницы:" + url());
        System.out.println("Заголовок страницы:" + title());
        System.out.println("Скриншот всей страницы здесь: " + pngFileName);
        System.out.println("Скриншот элемента [id=search-result] здесь: " + screenshot_file.getPath());
    }

    @Test
    void lesson11_form_example() {
        open("http://92.51.36.108:7777/top.academy/lesson11_forms/v01/");
        sleep(1);
        $("[name=firstname]").shouldBe(exist);
        $("[name=firstname]").setValue("Сергей");
        sleep(1);
        $("[id=remote]").shouldBe(exist);
        $("[id=remote]").click();

        $("[id=testlead]").shouldBe(exist);
        $("[id=testlead]").click();

        $("[type=submit]").shouldBe(exist);
        $("[type=submit]").click();

        //Открывается страница с результатами
        $(withText("зовут: Сергей")).shouldBe(exist);

        sleep(5000);
    }

    @Test
    void lesson12_selector_types() {

        //Цикл для ожидания прохождения капчи с проверками каждые int_seconds_wait секунд
        int int_seconds_wait = 5;
        open("https://google.com");
        for (int int_counter=0; int_counter<=100; int_counter++){
            if($("#captcha-form").exists()) {
                System.out.println("На странице капча. Прошло " + int_counter*int_seconds_wait + " секунд.");
                sleep(int_seconds_wait * 1000);
            }
        }


        $("#APjFqb").setValue("Поиск по id: $(\"#APjFqb\")");
        sleep(5000);
        $("#APjFqb").clear();

        $("[name=q]").setValue("Поиск по имени: $(\"[name=q]\")");
        sleep(5000);
        $("[name=q]").clear();

        $("[title=Search]").setValue("Поиск по названию атрибута: $(\"[title=Search]\")");
        sleep(5000);
        $("[name=q]").clear();

        $("textarea").sendKeys("Поиск по названию тегу: $(\"textarea\")");
        sleep(5000);
        $("textarea").clear();

        $(".gLFyf").setValue("Поиск по имени класса: $(\".gLFyf\")");
        sleep(5000);
        $(".gLFyf").clear();

        $(".a4bIc > textarea").setValue("Поиск по CSS-селектору (у родителя - имя класса > тег: $(\".a4bIc > textarea\")");
        sleep(5000);
        $(".gLFyf").clear();


    }

    @Test
    void google1() {
        open("https://www.google.com/");
        $("#APjFqb").should(exist);
        sleep(5000);


}
    @Test
    void google2() {
        open("https://www.google.com/");
        $(".gLFyf").should(exist);
        sleep(5000);


    }

    @Test
    void google3() {
        open("https://www.google.com/");
        $("[name=\"q\"]").should(exist);
        sleep(5000);


    }
    @Test
    void google4() {
        open("https://www.google.com/");
        $("[name=\"q\"]").should(exist);
        sleep(5000);


    }
}

















