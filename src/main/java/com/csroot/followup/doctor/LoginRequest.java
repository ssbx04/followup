package com.csroot.followup.doctor;

public record LoginRequest(
        String email,
        String password
) {}