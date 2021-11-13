package com.playground;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Play {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            // Set the headless option to false and change the test execution speed.
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(">> Page title: " + page.title());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("pasta-1", "pasta-2", "mais-um.png")));
        }

        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();
            page.navigate("http://whatsmyuseragent.org/");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("exemplo.png")));
        }

        try (Playwright playwright = Playwright.create()) {
            BrowserType chromium = playwright.chromium();
            // Make sure to run headed.
            Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
            // Setup context however you like.
            BrowserContext context = browser.newContext(/* pass any options */);
            context.route("**/*", route -> route.resume());
            // Pause the page, and start recording manually.
            Page page = context.newPage();
            page.pause();
        }
    }
}
