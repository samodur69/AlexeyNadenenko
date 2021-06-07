
package ru.training.at.hwapi.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Prefs {

    @SerializedName("permissionLevel")
    @Expose
    private String permissionLevel;
    @SerializedName("hideVotes")
    @Expose
    private Boolean hideVotes;
    @SerializedName("voting")
    @Expose
    private String voting;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("invitations")
    @Expose
    private String invitations;
    @SerializedName("selfJoin")
    @Expose
    private Boolean selfJoin;
    @SerializedName("cardCovers")
    @Expose
    private Boolean cardCovers;
    @SerializedName("isTemplate")
    @Expose
    private Boolean isTemplate;
    @SerializedName("cardAging")
    @Expose
    private String cardAging;
    @SerializedName("calendarFeedEnabled")
    @Expose
    private Boolean calendarFeedEnabled;
    @SerializedName("background")
    @Expose
    private String background;
    @SerializedName("backgroundImage")
    @Expose
    private Object backgroundImage;
    @SerializedName("backgroundImageScaled")
    @Expose
    private Object backgroundImageScaled;
    @SerializedName("backgroundTile")
    @Expose
    private Boolean backgroundTile;
    @SerializedName("backgroundBrightness")
    @Expose
    private String backgroundBrightness;
    @SerializedName("backgroundColor")
    @Expose
    private String backgroundColor;
    @SerializedName("backgroundBottomColor")
    @Expose
    private String backgroundBottomColor;
    @SerializedName("backgroundTopColor")
    @Expose
    private String backgroundTopColor;
    @SerializedName("canBePublic")
    @Expose
    private Boolean canBePublic;
    @SerializedName("canBeEnterprise")
    @Expose
    private Boolean canBeEnterprise;
    @SerializedName("canBeOrg")
    @Expose
    private Boolean canBeOrg;
    @SerializedName("canBePrivate")
    @Expose
    private Boolean canBePrivate;
    @SerializedName("canInvite")
    @Expose
    private Boolean canInvite;

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public Boolean getHideVotes() {
        return hideVotes;
    }

    public void setHideVotes(Boolean hideVotes) {
        this.hideVotes = hideVotes;
    }

    public String getVoting() {
        return voting;
    }

    public void setVoting(String voting) {
        this.voting = voting;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getInvitations() {
        return invitations;
    }

    public void setInvitations(String invitations) {
        this.invitations = invitations;
    }

    public Boolean getSelfJoin() {
        return selfJoin;
    }

    public void setSelfJoin(Boolean selfJoin) {
        this.selfJoin = selfJoin;
    }

    public Boolean getCardCovers() {
        return cardCovers;
    }

    public void setCardCovers(Boolean cardCovers) {
        this.cardCovers = cardCovers;
    }

    public Boolean getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Boolean isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getCardAging() {
        return cardAging;
    }

    public void setCardAging(String cardAging) {
        this.cardAging = cardAging;
    }

    public Boolean getCalendarFeedEnabled() {
        return calendarFeedEnabled;
    }

    public void setCalendarFeedEnabled(Boolean calendarFeedEnabled) {
        this.calendarFeedEnabled = calendarFeedEnabled;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Object getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Object backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public Object getBackgroundImageScaled() {
        return backgroundImageScaled;
    }

    public void setBackgroundImageScaled(Object backgroundImageScaled) {
        this.backgroundImageScaled = backgroundImageScaled;
    }

    public Boolean getBackgroundTile() {
        return backgroundTile;
    }

    public void setBackgroundTile(Boolean backgroundTile) {
        this.backgroundTile = backgroundTile;
    }

    public String getBackgroundBrightness() {
        return backgroundBrightness;
    }

    public void setBackgroundBrightness(String backgroundBrightness) {
        this.backgroundBrightness = backgroundBrightness;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBackgroundBottomColor() {
        return backgroundBottomColor;
    }

    public void setBackgroundBottomColor(String backgroundBottomColor) {
        this.backgroundBottomColor = backgroundBottomColor;
    }

    public String getBackgroundTopColor() {
        return backgroundTopColor;
    }

    public void setBackgroundTopColor(String backgroundTopColor) {
        this.backgroundTopColor = backgroundTopColor;
    }

    public Boolean getCanBePublic() {
        return canBePublic;
    }

    public void setCanBePublic(Boolean canBePublic) {
        this.canBePublic = canBePublic;
    }

    public Boolean getCanBeEnterprise() {
        return canBeEnterprise;
    }

    public void setCanBeEnterprise(Boolean canBeEnterprise) {
        this.canBeEnterprise = canBeEnterprise;
    }

    public Boolean getCanBeOrg() {
        return canBeOrg;
    }

    public void setCanBeOrg(Boolean canBeOrg) {
        this.canBeOrg = canBeOrg;
    }

    public Boolean getCanBePrivate() {
        return canBePrivate;
    }

    public void setCanBePrivate(Boolean canBePrivate) {
        this.canBePrivate = canBePrivate;
    }

    public Boolean getCanInvite() {
        return canInvite;
    }

    public void setCanInvite(Boolean canInvite) {
        this.canInvite = canInvite;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Prefs.class
                .getName())
                .append('@')
                .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("permissionLevel");
        sb.append('=');
        sb.append(((this.permissionLevel == null) ? "<null>" : this.permissionLevel));
        sb.append(',');
        sb.append("hideVotes");
        sb.append('=');
        sb.append(((this.hideVotes == null) ? "<null>" : this.hideVotes));
        sb.append(',');
        sb.append("voting");
        sb.append('=');
        sb.append(((this.voting == null) ? "<null>" : this.voting));
        sb.append(',');
        sb.append("comments");
        sb.append('=');
        sb.append(((this.comments == null) ? "<null>" : this.comments));
        sb.append(',');
        sb.append("invitations");
        sb.append('=');
        sb.append(((this.invitations == null) ? "<null>" : this.invitations));
        sb.append(',');
        sb.append("selfJoin");
        sb.append('=');
        sb.append(((this.selfJoin == null) ? "<null>" : this.selfJoin));
        sb.append(',');
        sb.append("cardCovers");
        sb.append('=');
        sb.append(((this.cardCovers == null) ? "<null>" : this.cardCovers));
        sb.append(',');
        sb.append("isTemplate");
        sb.append('=');
        sb.append(((this.isTemplate == null) ? "<null>" : this.isTemplate));
        sb.append(',');
        sb.append("cardAging");
        sb.append('=');
        sb.append(((this.cardAging == null) ? "<null>" : this.cardAging));
        sb.append(',');
        sb.append("calendarFeedEnabled");
        sb.append('=');
        sb.append(((this.calendarFeedEnabled == null) ? "<null>" : this.calendarFeedEnabled));
        sb.append(',');
        sb.append("background");
        sb.append('=');
        sb.append(((this.background == null) ? "<null>" : this.background));
        sb.append(',');
        sb.append("backgroundImage");
        sb.append('=');
        sb.append(((this.backgroundImage == null) ? "<null>" : this.backgroundImage));
        sb.append(',');
        sb.append("backgroundImageScaled");
        sb.append('=');
        sb.append(((this.backgroundImageScaled == null) ? "<null>" : this.backgroundImageScaled));
        sb.append(',');
        sb.append("backgroundTile");
        sb.append('=');
        sb.append(((this.backgroundTile == null) ? "<null>" : this.backgroundTile));
        sb.append(',');
        sb.append("backgroundBrightness");
        sb.append('=');
        sb.append(((this.backgroundBrightness == null) ? "<null>" : this.backgroundBrightness));
        sb.append(',');
        sb.append("backgroundColor");
        sb.append('=');
        sb.append(((this.backgroundColor == null) ? "<null>" : this.backgroundColor));
        sb.append(',');
        sb.append("backgroundBottomColor");
        sb.append('=');
        sb.append(((this.backgroundBottomColor == null) ? "<null>" : this.backgroundBottomColor));
        sb.append(',');
        sb.append("backgroundTopColor");
        sb.append('=');
        sb.append(((this.backgroundTopColor == null) ? "<null>" : this.backgroundTopColor));
        sb.append(',');
        sb.append("canBePublic");
        sb.append('=');
        sb.append(((this.canBePublic == null) ? "<null>" : this.canBePublic));
        sb.append(',');
        sb.append("canBeEnterprise");
        sb.append('=');
        sb.append(((this.canBeEnterprise == null) ? "<null>" : this.canBeEnterprise));
        sb.append(',');
        sb.append("canBeOrg");
        sb.append('=');
        sb.append(((this.canBeOrg == null) ? "<null>" : this.canBeOrg));
        sb.append(',');
        sb.append("canBePrivate");
        sb.append('=');
        sb.append(((this.canBePrivate == null) ? "<null>" : this.canBePrivate));
        sb.append(',');
        sb.append("canInvite");
        sb.append('=');
        sb.append(((this.canInvite == null) ? "<null>" : this.canInvite));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}