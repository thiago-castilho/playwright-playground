package com.playground;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

public class Example {
    public static void main(String[] args) {
        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)  // Habilita/ Desabilita execução em modo headless.
                            .setSlowMo(100)      // Define a velocidade de execução do teste.
                            .setDevtools(true))  // Habilida a caixa de ferramentas DevTools.
                    ;
            Page page = browser.newPage();
            page.navigate("https://www.google.com");
            page.pause();  // Pausa a execução para obter o mapeamento da página desejada, além de abrir o inspector do Playright.
            System.out.println(page.title());
        }
    }
}
