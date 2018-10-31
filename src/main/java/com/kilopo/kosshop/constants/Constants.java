package com.kilopo.kosshop.constants;

public interface Constants {
    final String BASE_PACKAGE = "com.kilopo.kosshop";
    final String TILES_CONF_PATH = "/WEB-INF/tiles/tiles.xml";

    interface Database {
        final String PROPERTIES_SOURCE = "classpath:db.properties";
    }

    interface View {
        final String HOME_PAGE = "home";
        final String RESULT_SEARCH_PAGE = "resultSearch";
        final String SEARCH_PAGE = "search";
        final String ADD_PAGE = "add";
    }
}
