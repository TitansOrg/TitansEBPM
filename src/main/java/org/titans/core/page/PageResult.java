package org.titans.core.page;

import java.util.ArrayList;
import java.util.List;

public class PageResult {

    // 总记录数
    private long totalCount;
    // 当前页号
    private int pageNo;
    // 总页数
    private int totalPageCount;
    // 页大小
    private int pageSize; 
    // 列表记录
    private List items;
    
    public PageResult() {
        
    }
    
    public PageResult(long totalCount, int pageNo, int pageSize, List items) {
        super();
        this.items = items == null ? new ArrayList() : items;
        this.totalCount = totalCount;
        if (totalCount > 0) {

            this.pageNo = pageNo;
            int tem = (int) totalCount / pageSize;
            this.totalPageCount = (totalCount % pageSize == 0) ? tem : (tem + 1);
        } else {

            this.pageNo = 0;
            this.totalPageCount = 0;
        }
        this.pageSize = pageSize;
    }
    /**
     * @return the totalCount
     */
    public long getTotalCount() {
        return totalCount;
    }
    /**
     * @param totalCount the totalCount to set
     */
    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
    /**
     * @return the pageNo
     */
    public int getPageNo() {
        return pageNo;
    }
    /**
     * @param pageNo the pageNo to set
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    /**
     * @return the totalPage
     */
    public int getTotalPageCount() {
        return totalPageCount;
    }
    /**
     * @param totalPage the totalPage to set
     */
    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }
    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }
    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        
        this.pageSize = pageSize;
    }
    /**
     * @return the items
     */
    public List getItems() {
        return items;
    }
    /**
     * @param items the items to set
     */
    public void setItems(List items) {
        this.items = items;
    }
    
    
}
