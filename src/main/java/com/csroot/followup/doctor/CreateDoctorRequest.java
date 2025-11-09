package com.csroot.followup.doctor;

public record CreateDoctorRequest(
        String name,
        String email,
        String password,
        String specialty
) {}