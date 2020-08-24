package com.example.springboottesting.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Swagger generated API model Error.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-11-21T18:47" +
        ":15.082Z")
public class Error {

    /** The code. */
    @JsonProperty("code")
    private Integer code = null;

    /** The message. */
    @JsonProperty("message")
    private String message = null;

    /** The method. */
    @JsonProperty("method")
    private String method = null;

    /** The vendor. */
    @JsonProperty("vendor")
    private String vendor = null;

    /** The status. */
    @JsonProperty("status")
    private Integer status = null;

    /** The attributes. */
    @JsonProperty("attributes")
    private List<ErrorAttributes> attributes = null;

    /**
     * Code.
     * @param code the code
     * @return the error
     */
    public Error code(Integer code) {
        this.code = code;
        return this;
    }

    /**
     * the code will be mapped to a specific message per microservice. The first 4 digits represent
     * the microservice. Then the last 3 are for a specific error message. The codes will be stored
     * and available to lookup in the wiki
     *
     * @return code
     **/
    @JsonProperty("code")
    public Integer getCode() {
        return code;
    }

    /**
     * Sets the code.
     * @param code the new code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * Message.
     * @param message the message
     * @return the error
     */
    public Error message(String message) {
        this.message = message;
        return this;
    }

    /**
     * this will be the technical message that will be passed along.
     * @return message
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Method.
     * @param method the method
     * @return the error
     */
    public Error method(String method) {
        this.method = method;
        return this;
    }

    /**
     * this will be the name of the call that you are making on the vendor&#39;s API.
     * @return method
     */
    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    /**
     * Sets the method.
     * @param method the new method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Vendor.
     * @param vendor the vendor
     * @return the error
     */
    public Error vendor(String vendor) {
        this.vendor = vendor;
        return this;
    }

    /**
     * which vendor are we reaching out to with the call - SharedServices, iQMetrix, DAO, Cassandra.
     * @return vendor
     */
    @JsonProperty("vendor")
    public String getVendor() {
        return vendor;
    }

    /**
     * Sets the vendor.
     * @param vendor the new vendor
     */
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    /**
     * Status.
     * @param status the status
     * @return the error
     */
    public Error status(Integer status) {
        this.status = status;
        return this;
    }

    /**
     * the http status code that came with the error.
     * @return status
     */
    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets the status.
     * @param status the new status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Attributes.
     * @param attributes the attributes
     * @return the error
     */
    public Error attributes(List<ErrorAttributes> attributes) {
        this.attributes = attributes;
        return this;
    }

    /**
     * Adds the attributes item.
     * @param attributesItem the attributes item
     * @return the error
     */
    public Error addAttributesItem(ErrorAttributes attributesItem) {
        if (this.attributes == null) {
            this.attributes = new ArrayList<ErrorAttributes>();
        }
        this.attributes.add(attributesItem);
        return this;
    }

    /**
     * array of data attributes and reasons they are invalid.
     * @return attributes
     */
    @JsonProperty("attributes")
    public List<ErrorAttributes> getAttributes() {
        return attributes;
    }

    /**
     * Sets the attributes.
     * @param attributes the new attributes
     */
    public void setAttributes(List<ErrorAttributes> attributes) {
        this.attributes = attributes;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Error error = (Error) o;
        return Objects.equals(this.code, error.code) && Objects.equals(this.message, error.message)
                && Objects.equals(this.method, error.method)
                && Objects.equals(this.vendor, error.vendor)
                && Objects.equals(this.status, error.status)
                && Objects.equals(this.attributes, error.attributes);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(code, message, method, vendor, status, attributes);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Error {\n");

        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    method: ").append(toIndentedString(method)).append("\n");
        sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     * @param o the o
     * @return the string
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
