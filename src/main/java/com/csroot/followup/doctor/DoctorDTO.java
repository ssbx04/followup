package com.csroot.followup.doctor;

import java.time.LocalDateTime;

public record DoctorDTO(
        Long id,
        String name,
        String email,
        String specialty,
        LocalDateTime createdAt
) {
}
