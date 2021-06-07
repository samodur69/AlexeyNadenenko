
package ru.training.at.hwapi.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class BoardList {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("closed")
    @Expose
    private Boolean closed;
    @SerializedName("pos")
    @Expose
    private Integer pos;
    @SerializedName("softLimit")
    @Expose
    private Object softLimit;
    @SerializedName("idBoard")
    @Expose
    private String idBoard;
    @SerializedName("subscribed")
    @Expose
    private Boolean subscribed;

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

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public Object getSoftLimit() {
        return softLimit;
    }

    public void setSoftLimit(Object softLimit) {
        this.softLimit = softLimit;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public Boolean getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BoardList.class
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
        sb.append("closed");
        sb.append('=');
        sb.append(((this.closed == null) ? "<null>" : this.closed));
        sb.append(',');
        sb.append("pos");
        sb.append('=');
        sb.append(((this.pos == null) ? "<null>" : this.pos));
        sb.append(',');
        sb.append("softLimit");
        sb.append('=');
        sb.append(((this.softLimit == null) ? "<null>" : this.softLimit));
        sb.append(',');
        sb.append("idBoard");
        sb.append('=');
        sb.append(((this.idBoard == null) ? "<null>" : this.idBoard));
        sb.append(',');
        sb.append("subscribed");
        sb.append('=');
        sb.append(((this.subscribed == null) ? "<null>" : this.subscribed));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.subscribed == null) ? 0 : this.subscribed.hashCode()));
        result = ((result * 31) + ((this.idBoard == null) ? 0 : this.idBoard.hashCode()));
        result = ((result * 31) + ((this.pos == null) ? 0 : this.pos.hashCode()));
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.closed == null) ? 0 : this.closed.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.softLimit == null) ? 0 : this.softLimit.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BoardList) == false) {
            return false;
        }
        BoardList rhs = ((BoardList) other);
        return (((((((Objects.equals(this.subscribed, rhs.subscribed))
                && (Objects.equals(this.idBoard, rhs.idBoard)))
                && (Objects.equals(this.pos, rhs.pos)))
                && (Objects.equals(this.name, rhs.name)))
                && (Objects.equals(this.closed, rhs.closed)))
                && (Objects.equals(this.id, rhs.id)))
                && (Objects.equals(this.softLimit, rhs.softLimit)));
    }

}
