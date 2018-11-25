package com.kilopo.kosshop.constants;

public interface Constants {
    final String BASE_PACKAGE = "com.kilopo.kosshop";
    final String TILES_CONF_PATH = "/WEB-INF/tiles/tiles.xml";
    final String PHOTOS_DIRECTORY = "uploads/photos";

    interface Database {
        final String PROPERTIES_SOURCE = "classpath:db.properties";
    }

    interface View {
        final String HOME_PAGE = "home";
        final String PRODUCTS_PAGE = "products";
        final String ADD_PAGE = "add";
    }

    interface Extension {
        final String IMAGE_EXTANSION = ".png";
    }
}
