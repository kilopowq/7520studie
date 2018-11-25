package com.kilopo.kosshop.service.Impl;

import com.kilopo.kosshop.DAO.ProductDAO;
import com.kilopo.kosshop.constants.Constants;
import com.kilopo.kosshop.entity.Product;
import com.kilopo.kosshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    public boolean add(Product product, MultipartFile image) {
        File uploads = new File(Constants.PHOTOS_DIRECTORY);
        if(!uploads.exists()){
            uploads.mkdirs();
        }
        String uniqueID = UUID.randomUUID().toString() + Constants.Extension.IMAGE_EXTANSION;
        File UUIDImage = new File(Constants.PHOTOS_DIRECTORY + File.separator + uniqueID);
        if (!image.isEmpty()) {
            try {
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(UUIDImage));
                stream.write(image.getBytes());
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        product.setImage(uniqueID);
        return productDAO.addOrUpdate(product) != null;
    }

    public List<Product> searchByFields(Map<String, String> mapProductParam) {
        Map<String, String> filteredmap = mapProductParam.entrySet().stream().filter(mapEntry -> !mapEntry.getValue()
                .equals("")).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return productDAO.findByFields(filteredmap);
    }

    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public List<Product> getByColumnNameAndValue(String name, Object value) {
        return productDAO.getByColumnNameAndValue(name,value);
    }
}
