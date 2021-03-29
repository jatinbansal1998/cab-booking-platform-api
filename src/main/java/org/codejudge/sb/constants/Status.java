package org.codejudge.sb.constants;

public enum Status {
    FAILURE("failure"), SUCCESS("success");
    private final String value;

    public String getValue() {
        return this.value;
    }

    Status(String value) {
        this.value = value;
    }
}
