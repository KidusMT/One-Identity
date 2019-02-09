
package com.gdg.app.data.db.model.person;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonResponse {

    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("pages")
    @Expose
    private Integer pages;
    @SerializedName("total_docs")
    @Expose
    private Integer totalDocs;
    @SerializedName("data")
    @Expose
    private List<Person> data = null;

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getTotalDocs() {
        return totalDocs;
    }

    public void setTotalDocs(Integer totalDocs) {
        this.totalDocs = totalDocs;
    }

    public List<Person> getPerson() {
        return data;
    }

    public void setPerson(List<Person> data) {
        this.data = data;
    }

}
