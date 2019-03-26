package com.kilopo.kosshop.constants;

public interface Constants {
    final String BASE_PACKAGE = "com.kilopo.kosshop";
    final String TILES_CONF_PATH = "/WEB-INF/tiles/tiles.xml";

    interface Database {
        final String PROPERTIES_SOURCE = "classpath:db.properties";
    }

    interface View {
        final String HOME_PAGE = "home";
        final String PRODUCTS_PAGE = "products";
        final String ADD_PAGE = "add";

    }

    interface ControllerPath {
        final String ADD_BASE = "redirect:/add";
    }

    interface Locale {
        final String NAME = "mylocale";
        final String EN = "en";
        final String UK = "uk";
    }
}
