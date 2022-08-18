package com.example.feginclientdemo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomizationCommonDto {

    @JsonProperty("theme_color")
    private String themeColor;
    @JsonProperty("is_twitter_icon_enabled")
    private String twitterIconEnabled;
    @JsonProperty("attr_window_size")
    private String windowSize;
    @JsonProperty("is_facebook_icon_enabled")
    private String facebookIconEnabled;
    @JsonProperty("is_instagram_icon_enabled")
    private String instagramIconEnabled;
    @JsonProperty("theme_name")
    private String themeName;
    @JsonProperty("attr_banner_position")
    private String bannerPosition;
    @JsonProperty("text_color")
    private String textColor;

    public String getThemeColor() {
        return themeColor;
    }
    public CustomizationCommonDto setThemeColor(String themeColor) {
        this.themeColor = themeColor;
        return this;
    }
    public String getTwitterIconEnabled() {
        return twitterIconEnabled;
    }
    public CustomizationCommonDto setTwitterIconEnabled(String twitterIconEnabled) {
        this.twitterIconEnabled = twitterIconEnabled;
        return this;
    }
    public String getWindowSize() {
        return windowSize;
    }
    public CustomizationCommonDto setWindowSize(String windowSize) {
        this.windowSize = windowSize;
        return this;
    }
    public String getFacebookIconEnabled() {
        return facebookIconEnabled;
    }
    public CustomizationCommonDto setFacebookIconEnabled(String facebookIconEnabled) {
        this.facebookIconEnabled = facebookIconEnabled;
        return this;
    }
    public String getThemeName() {
        return themeName;
    }
    public CustomizationCommonDto setThemeName(String themeName) {
        this.themeName = themeName;
        return this;
    }
    public String getBannerPosition() {
        return bannerPosition;
    }
    public CustomizationCommonDto setBannerPosition(String bannerPosition) {
        this.bannerPosition = bannerPosition;
        return this;
    }

    public String getInstagramIconEnabled() {
        return instagramIconEnabled;
    }
    public CustomizationCommonDto setInstagramIconEnabled(String instagramIconEnabled) {
        this.instagramIconEnabled = instagramIconEnabled;
        return this;
    }
    public String getTextColor() {
        return textColor;
    }
    public CustomizationCommonDto setTextColor(String textColor) {
        this.textColor = textColor;
        return this;
    }

}
