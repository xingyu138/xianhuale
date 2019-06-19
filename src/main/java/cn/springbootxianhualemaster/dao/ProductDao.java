package cn.springbootxianhualemaster.dao;


import cn.springbootxianhualemaster.pojo.Products;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDao {
    private static String url = "http://localhost:8081/solr/test/";
    private BaseDao<Products> productBaseDao = new BaseDao<Products>(url);

    public List<Products> queryProduct(String keyword) {
        SolrQuery solrQuery = new SolrQuery("keyword:" + keyword);
        solrQuery.setStart(0);
        //一页显示多少条
        solrQuery.setRows(100);
        List<Products> productList = productBaseDao.queryList(solrQuery, Products.class);
        System.out.println(productList);
        for (Products product : productList) {

            System.out.println(product.getProductName());
        }
        return productList;
    }
}