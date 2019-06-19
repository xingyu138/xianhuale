package cn.springbootxianhualemaster.dao;


import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.io.IOException;
import java.util.List;

public class BaseDao<T> {

    private  HttpSolrClient httpSolrClient=null;
    private QueryResponse response = null;
    public BaseDao(String url){
        //初始化HttpSolrClient
        httpSolrClient = new HttpSolrClient(url);
        httpSolrClient.setParser(new XMLResponseParser()); // 设置响应解析器
        httpSolrClient.setConnectionTimeout(500); // 建立连接的最长时间
    }
    public List<T> queryList(SolrQuery query, Class clazz) {
        List<T> list = null;
        try {
            response = httpSolrClient.query(query);
            list = response.getBeans(clazz);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return list;
        }
    }
}