package com.kilopo.kosshop.constants;

public interface Constants {
    final String BASE_PACKAGE = "com.kilopo.kosshop";
    final String TILES_CONF_PATH = "/WEB-INF/tiles/tiles.xml";

    interface Database {
        final String PROPERTIES_SOURCE = "classpath:db.properties";
    }

    interface View {
        final String HOMEPAGE = "home";
    }

}
