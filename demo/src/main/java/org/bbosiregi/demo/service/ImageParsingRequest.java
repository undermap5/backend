package org.bbosiregi.demo.service;

public class ImageParsingRequest {
    private String url;
    private String question;
    private String[] options;
    private String selectedOption;
    private String followUpQuestion;

    public ImageParsingRequest() {}

    public ImageParsingRequest(String url, String question, String[] options, String selectedOption, String followUpQuestion) {
        this.url = url;
        this.question = question;
        this.options = options;
        this.selectedOption = selectedOption;
        this.followUpQuestion = followUpQuestion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public String getFollowUpQuestion() {
        return followUpQuestion;
    }

    public void setFollowUpQuestion(String followUpQuestion) {
        this.followUpQuestion = followUpQuestion;
    }
}