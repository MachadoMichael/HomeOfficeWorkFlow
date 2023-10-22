package com.ax.HomeOfficeWorkFlow.employee.entities;

public enum LoginRole {
    USER("user"),
    ADMIN("users");

    private String role;

    LoginRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
