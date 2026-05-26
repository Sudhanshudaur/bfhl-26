package com.bfhl_26_Sudhanshu.bfhl_26.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonPropertyOrder({
    "is_success",
    "user_id",
    "email",
    "roll_number",
    "odd_numbers",
    "even_numbers",
    "alphabets",
    "special_characters",
    "sum",
    "concat_string"
})
public class BfhlResponse {
    
    private boolean isSuccess;
    private String userId;
    private String email;
    private String rollNumber;
    private List<String> oddNumbers;
    private List<String> evenNumbers;
    private List<String> alphabets;
    private List<String> specialCharacters;
    private String sum;
    private String concatString;

    // Getters and Setters
    @JsonProperty("is_success")
    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("roll_number")
    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    @JsonProperty("odd_numbers")
    public List<String> getOddNumbers() {
        return oddNumbers;
    }

    public void setOddNumbers(List<String> oddNumbers) {
        this.oddNumbers = oddNumbers;
    }

    @JsonProperty("even_numbers")
    public List<String> getEvenNumbers() {
        return evenNumbers;
    }

    public void setEvenNumbers(List<String> evenNumbers) {
        this.evenNumbers = evenNumbers;
    }

    @JsonProperty("alphabets")
    public List<String> getAlphabets() {
        return alphabets;
    }

    public void setAlphabets(List<String> alphabets) {
        this.alphabets = alphabets;
    }

    @JsonProperty("special_characters")
    public List<String> getSpecialCharacters() {
        return specialCharacters;
    }

    public void setSpecialCharacters(List<String> specialCharacters) {
        this.specialCharacters = specialCharacters;
    }

    @JsonProperty("sum")
    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    @JsonProperty("concat_string")
    public String getConcatString() {
        return concatString;
    }

    public void setConcatString(String concatString) {
        this.concatString = concatString;
    }
}
