package com.csroot.followup.doctor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorMapper {

    public DoctorDTO toDto(Doctor doctor) {
        if (doctor == null) {
            return null;
        }

        return new DoctorDTO(
                doctor.getId(),
                doctor.getName(),
                doctor.getEmail(),
                doctor.getSpecialty(),
                doctor.getCreatedAt()
        );
    }

    public Doctor toEntity(DoctorDTO dto) {
        if (dto == null) {
            return null;
        }

        Doctor doctor = new Doctor();
        doctor.setId(dto.id());
        doctor.setName(dto.name());
        doctor.setEmail(dto.email());
        doctor.setSpecialty(dto.specialty());
        doctor.setCreatedAt(dto.createdAt());

        return doctor;
    }

}
