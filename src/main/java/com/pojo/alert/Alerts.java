package com.pojo.alert;

public class Alerts {
    private SimpleAlert simpleAlert;
    private ConfirmationAlert confirmationAlert;
    private PromptAlert promptAlert;

    public SimpleAlert getSimpleAlert() {
        return simpleAlert;
    }

    public ConfirmationAlert getConfirmationAlert() {
        return confirmationAlert;
    }

    public PromptAlert getPromptAlert() {
        return promptAlert;
    }

    public static class SimpleAlert {
        private String question;
        public String getQuestion() {
            return question;
        }
    }

    public static class ConfirmationAlert {
        private String question;
        private String textOk;
        private String textCancel;

        public String getQuestion() {
            return question;
        }

        public String getTextOk() {
            return textOk;
        }

        public String getTextCancel() {
            return textCancel;
        }
    }

    public static class PromptAlert {
        private String question;
        private String value;
        private String text;

        public String getQuestion() {
            return question;
        }

        public String getValue() {
            return value;
        }

        public String getText() {
            return text;
        }
    }
}
