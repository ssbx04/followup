package com.csroot.followup.doctor;

public record UpdateDoctorRequest(
        String name,
        String specialty,
        String password
) {}