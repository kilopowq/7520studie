package com.kilopo.kosshop.constants;

public interface Constants {
    final String BASE_PACKAGE = "com.kilopo.kosshop";
    final String TILES_CONF_PATH = "/WEB-INF/tiles/tiles.xml";

    interface Database {
        final String PROPERTIES_SOURCE = "classpath:db.properties";
    }
    interface ProjectUrl {
        final String BASE_URL = "classpath:project.properties";
    }

    interface View {
        final String HOME_PAGE = "home";
        final String PRODUCTS_PAGE = "products";
        final String ADD_PAGE = "add";
        final String REGISTRATION = "registration";
        final String PRODUCTS_VIEW = "../tiles/template/header";

    }

    interface ControllerPath {
        final String ADD_BASE = "redirect:/add";
    }

    interface Locale {
        final String NAME = "mylocale";
        final String EN = "en";
        final String UK = "uk";
    }

    interface RegExp {
        final String LOGIN = "^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\\d.-]{1,20}$";
        final String PASSWORD = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{6,100}$";
        final String NAME = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
        final String SERNAME = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
        final String MIDDLENAME = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
        final String STREET = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$";
        final String HOUSE = "^\\d+[a-zA-Z]{0,1}$";
        final String CITY = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$";
    }

    interface ValidationMessage {
        final String STREET = "Must contain street name";
        final String HOUSE = "Must contain house number";
        final String CITY = "Must contain city name";
        final String LOGIN = "Wrong login name style";
        final String PASSWORD = "The size should be not less then 6 and contain " +
                "at least one upper case English letter and one digit";
        final String NAME = "Should not contain anything superfluous";
        final String SERNAME = "Should not contain anything superfluous";
        final String MIDDLENAME = "Should not contain anything superfluous";
    }
}
