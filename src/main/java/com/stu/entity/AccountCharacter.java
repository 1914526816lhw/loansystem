package com.stu.entity;

public class AccountCharacter {
    private Integer accountCharacterId;

    private String accountCharacterName;

    public Integer getAccountCharacterId() {
        return accountCharacterId;
    }

    public void setAccountCharacterId(Integer accountCharacterId) {
        this.accountCharacterId = accountCharacterId;
    }

    public String getAccountCharacterName() {
        return accountCharacterName;
    }

    public void setAccountCharacterName(String accountCharacterName) {
        this.accountCharacterName = accountCharacterName == null ? null : accountCharacterName.trim();
    }
}