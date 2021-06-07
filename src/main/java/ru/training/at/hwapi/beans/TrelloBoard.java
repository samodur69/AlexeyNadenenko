
package ru.training.at.hwapi.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.training.at.hwapi.beans.LabelNames;
import ru.training.at.hwapi.beans.Limits;
import ru.training.at.hwapi.beans.Prefs;

public class TrelloBoard {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("descData")
    @Expose
    private Object descData;
    @SerializedName("closed")
    @Expose
    private Boolean closed;
    @SerializedName("idOrganization")
    @Expose
    private String idOrganization;
    @SerializedName("idEnterprise")
    @Expose
    private Object idEnterprise;
    @SerializedName("pinned")
    @Expose
    private Boolean pinned;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("shortUrl")
    @Expose
    private String shortUrl;
    @SerializedName("prefs")
    @Expose
    private Prefs prefs;
    @SerializedName("labelNames")
    @Expose
    private LabelNames labelNames;
    @SerializedName("limits")
    @Expose
    private Limits limits;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getDescData() {
        return descData;
    }

    public void setDescData(Object descData) {
        this.descData = descData;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public Object getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(Object idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Prefs getPrefs() {
        return prefs;
    }

    public void setPrefs(Prefs prefs) {
        this.prefs = prefs;
    }

    public LabelNames getLabelNames() {
        return labelNames;
    }

    public void setLabelNames(LabelNames labelNames) {
        this.labelNames = labelNames;
    }

    public Limits getLimits() {
        return limits;
    }

    public void setLimits(Limits limits) {
        this.limits = limits;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TrelloBoard.class
                .getName())
                .append('@')
                .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("desc");
        sb.append('=');
        sb.append(((this.desc == null) ? "<null>" : this.desc));
        sb.append(',');
        sb.append("descData");
        sb.append('=');
        sb.append(((this.descData == null) ? "<null>" : this.descData));
        sb.append(',');
        sb.append("closed");
        sb.append('=');
        sb.append(((this.closed == null) ? "<null>" : this.closed));
        sb.append(',');
        sb.append("idOrganization");
        sb.append('=');
        sb.append(((this.idOrganization == null) ? "<null>" : this.idOrganization));
        sb.append(',');
        sb.append("idEnterprise");
        sb.append('=');
        sb.append(((this.idEnterprise == null) ? "<null>" : this.idEnterprise));
        sb.append(',');
        sb.append("pinned");
        sb.append('=');
        sb.append(((this.pinned == null) ? "<null>" : this.pinned));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null) ? "<null>" : this.url));
        sb.append(',');
        sb.append("shortUrl");
        sb.append('=');
        sb.append(((this.shortUrl == null) ? "<null>" : this.shortUrl));
        sb.append(',');
        sb.append("prefs");
        sb.append('=');
        sb.append(((this.prefs == null) ? "<null>" : this.prefs));
        sb.append(',');
        sb.append("labelNames");
        sb.append('=');
        sb.append(((this.labelNames == null) ? "<null>" : this.labelNames));
        sb.append(',');
        sb.append("limits");
        sb.append('=');
        sb.append(((this.limits == null) ? "<null>" : this.limits));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}
