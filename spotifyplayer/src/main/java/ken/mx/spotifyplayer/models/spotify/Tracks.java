
package ken.mx.spotifyplayer.models.spotify;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Tracks {

    @SerializedName("href")
    @Expose
    private String href;

    @SerializedName("items")
    @Expose
    private List<Item> items = new ArrayList<Item>();

    @SerializedName("limit")
    @Expose
    private int limit;

    @SerializedName("next")
    @Expose
    private String next;

    @SerializedName("offset")
    @Expose
    private int offset;

    @SerializedName("previous")
    @Expose
    private Object previous;

    @SerializedName("total")
    @Expose
    private int total;

    /**
     * @return The href
     */
    public String getHref() {
        return href;
    }

    /**
     * @param href The href
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * @return The items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items The items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * @return The limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @param limit The limit
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * @return The next
     */
    public String getNext() {
        return next;
    }

    /**
     * @param next The next
     */
    public void setNext(String next) {
        this.next = next;
    }

    /**
     * @return The offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @param offset The offset
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * @return The previous
     */
    public Object getPrevious() {
        return previous;
    }

    /**
     * @param previous The previous
     */
    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    /**
     * @return The total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total The total
     */
    public void setTotal(int total) {
        this.total = total;
    }

}
