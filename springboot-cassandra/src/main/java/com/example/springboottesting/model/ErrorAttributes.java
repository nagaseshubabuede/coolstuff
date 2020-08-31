package com.example.springboottesting.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorAttributes {
    @JsonProperty("attribute")
    private String attribute = null;

    @JsonProperty("reason")
    private String reason = null;

    public ErrorAttributes attribute(String attribute) {
        this.attribute = attribute;
        return this;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public ErrorAttributes reason(String reason) {
        this.reason = reason;
        return this;
    }


    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorAttributes errorAttributes = (ErrorAttributes) o;
        return Objects.equals(this.attribute, errorAttributes.attribute) &&
                Objects.equals(this.reason, errorAttributes.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attribute, reason);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorAttributes {\n");

        sb.append(" attribute: ").append(toIndentedString(attribute)).append("\n");
        sb.append(" reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n ");
    }
}
