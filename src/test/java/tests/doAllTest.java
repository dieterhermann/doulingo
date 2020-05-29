package tests;

import base.BaseTest;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import pages.LoginPage;
import pages.MainPage;
import pages.StoriesPage;
import pages.StoryPage;

import java.io.IOException;
import java.util.List;


public class doAllTest  extends BaseTest {
    private String USERNAME;
    private String PASSWORD;

    public doAllTest(){
        USERNAME = "armuri.spam@gmail.com";
        PASSWORD = "2EutUp9zWECwVFM";
    }

    @Test
    public void lesson1 () throws IOException, ParseException {
        LoginPage loginPage = homePage.haveAccountclick();
        loginPage.setUsername(USERNAME);
        loginPage.setPassword(PASSWORD);

        MainPage mainPage = loginPage.clickLoginButton();

        StoriesPage storiesPage = mainPage.gotoStories();
        StoryPage story =  storiesPage.storyClick(0);

        story.clickContinue(2);
        story.clickCorrectAnsver("Yes", 1);
        story.clickContinue(4);
        story.clickCorrectAnsver("where", 2);
        story.clickContinue(8);
        story.clickCorrectAnsver("coffee", 6);
        story.clickContinue(6);
        story.clickCorrectAnsver("coffee", 13);
        story.clickContinue(4);
        story.clickCorrectAnsver("What", 1);
        story.clickContinue(4);
        story.clickCorrectAnsver("salt", 6);
        story.clickContinue(1);
        story.cklickPairs();
        story.clickContinue(3);
    }

    @Test
    public void lesson2 () throws IOException, ParseException {
        LoginPage loginPage = homePage.haveAccountclick();
        loginPage.setUsername(USERNAME);
        loginPage.setPassword(PASSWORD);

        MainPage mainPage = loginPage.clickLoginButton();

        StoriesPage storiesPage = mainPage.gotoStories();
        StoryPage story =  storiesPage.storyClick(1);

        story.clickContinue(5);
        story.clickCorrectAnsver("what", 2);
        story.clickContinue(6);
        story.clickCorrectAnsver("Yes", 1);
        story.clickContinue(6);
        story.clickCorrectAnsver("Italian", 7);
        story.clickContinue(3);

        String[] buttonList = {"Hast", "du", "Hunde", "oder", "Katzen"};
        story.cklickButtonList(buttonList);

        story.clickCorrectAnsver("coffee", 13);
        story.clickContinue(4);
        story.clickCorrectAnsver("What", 1);
        story.clickContinue(4);
        story.clickCorrectAnsver("salt", 6);
        story.clickContinue(1);
        story.cklickPairs();
        story.clickContinue(3);
    }

}
