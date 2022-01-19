package com.hsbc.cmb.hk.dbb.pages.systemManagement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class scf_page extends PageObject {

    @FindBy(xpath = "//span[text()='More']")
    public WebElementFacade more;
}
