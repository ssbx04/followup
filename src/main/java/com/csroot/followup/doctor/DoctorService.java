package com.csroot.followup.doctor;

import org.springframework.stereotype.Service;
import com.csroot.followup.config.PasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;
    private final PasswordEncoder passwordEncoder;

    public DoctorService(
            DoctorRepository doctorRepository,
            DoctorMapper doctorMapper,
            PasswordEncoder passwordEncoder
    ) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Créer un nouveau médecin (inscription)
     */
    public DoctorDTO create(CreateDoctorRequest request) {
        // Vérifier si l'email existe déjà
        if (doctorRepository.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("Un médecin avec cet email existe déjà");
        }

        Doctor doctor = new Doctor();
        doctor.setName(request.name());
        doctor.setEmail(request.email());
        doctor.setPassword(passwordEncoder.encode(request.password()));
        doctor.setSpecialty(request.specialty());

        Doctor saved = doctorRepository.save(doctor);
        return doctorMapper.toDto(saved);
    }

    /**
     * Authentifier un médecin
     */
    public DoctorDTO authenticate(LoginRequest request) {
        Optional<Doctor> doctorOpt = doctorRepository.findByEmail(request.email());

        if (doctorOpt.isEmpty()) {
            throw new RuntimeException("Email ou mot de passe incorrect");
        }

        Doctor doctor = doctorOpt.get();

        // Vérifier le mot de passe
        if (!passwordEncoder.matches(request.password(), doctor.getPassword())) {
            throw new RuntimeException("Email ou mot de passe incorrect");
        }

        return doctorMapper.toDto(doctor);
    }

    /**
     * Récupérer un médecin par ID
     */
    public DoctorDTO findById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médecin non trouvé"));
        return doctorMapper.toDto(doctor);
    }

    /**
     * Récupérer tous les médecins
     */
    public List<DoctorDTO> findAll() {
        return doctorRepository.findAll()
                .stream()
                .map(doctorMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Mettre à jour un médecin
     */
    public DoctorDTO update(Long id, UpdateDoctorRequest request) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médecin non trouvé"));

        if (request.name() != null) {
            doctor.setName(request.name());
        }
        if (request.specialty() != null) {
            doctor.setSpecialty(request.specialty());
        }
        if (request.password() != null && !request.password().isEmpty()) {
            doctor.setPassword(passwordEncoder.encode(request.password()));
        }

        Doctor updated = doctorRepository.save(doctor);
        return doctorMapper.toDto(updated);
    }

    /**
     * Supprimer un médecin
     */
    public void delete(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new RuntimeException("Médecin non trouvé");
        }
        doctorRepository.deleteById(id);
    }
}