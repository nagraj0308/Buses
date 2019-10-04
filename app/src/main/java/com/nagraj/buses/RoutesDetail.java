
package com.nagraj.buses;

import androidx.versionedparcelable.ParcelField;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RoutesDetail {

    @SerializedName("routes")
    @Expose
    private List<Route> routes = null;

    @SerializedName("search_query")
    @Expose
    private SearchQuery searchQuery;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public SearchQuery getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(SearchQuery searchQuery) {
        this.searchQuery = searchQuery;
    }

}
