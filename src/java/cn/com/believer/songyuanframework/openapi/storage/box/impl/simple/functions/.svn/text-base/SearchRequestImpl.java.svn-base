/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.SearchRequest;

/**
 * @author jjia
 * 
 */
public class SearchRequestImpl extends BoxRequestImpl implements SearchRequest {

    /** auth token. */
    private String authToken;

    /** The text of which the user wishes to perform a search. */
    private String query;

    /**
     * The page number, which begins on page 1. This coincides with the per_page
     * parameter.
     */
    private long page;

    /** The number of search results to display per page. */
    private long perPage;

    /**
     * The method in which the results may be sorted. Values can be 'relevance',
     * 'name', 'date', or 'size'.
     */
    private String sort;

    /**
     * Can specify whether to sort content in ascending or descending order.
     * Values can be 'asc' or 'desc'.
     */
    private String direction;

    /**
     * Allows you to set additional, optional parameters:
     * 
     * 'show_description' - Search results include the description of the file
     * or folder returned. 'show_path' - Search results include the absolute
     * path where a file or folder is located. .
     */
    private String[] params;

    /**
     * @return action name
     */
    public String getActionName() {
        return BoxConstant.ACTION_NAME_SEARCH;
    }

    /**
     * @return the authToken
     */
    public String getAuthToken() {
        return this.authToken;
    }

    /**
     * @param authToken
     *            the authToken to set
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     * @return the query
     */
    public String getQuery() {
        return this.query;
    }

    /**
     * @param query
     *            the query to set
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * @return the page
     */
    public long getPage() {
        return this.page;
    }

    /**
     * @param page
     *            the page to set
     */
    public void setPage(long page) {
        this.page = page;
    }

    /**
     * @return the perPage
     */
    public long getPerPage() {
        return this.perPage;
    }

    /**
     * @param perPage
     *            the perPage to set
     */
    public void setPerPage(long perPage) {
        this.perPage = perPage;
    }

    /**
     * @return the sort
     */
    public String getSort() {
        return this.sort;
    }

    /**
     * @param sort
     *            the sort to set
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * @return the direction
     */
    public String getDirection() {
        return this.direction;
    }

    /**
     * @param direction
     *            the direction to set
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * @return the params
     */
    public String[] getParams() {
        return this.params;
    }

    /**
     * @param params
     *            the params to set
     */
    public void setParams(String[] params) {
        this.params = params;
    }

}
