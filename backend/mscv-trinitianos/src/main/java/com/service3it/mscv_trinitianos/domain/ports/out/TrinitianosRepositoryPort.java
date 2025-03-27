package com.service3it.mscv_trinitianos.domain.ports.out;

import java.util.List;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;

public interface TrinitianosRepositoryPort {

    Trinitianos getTrinitianosById(Long id);

    Trinitianos saveTrinitianos(Trinitianos trinitianos);

    List<Trinitianos> getAllTrinitianos();

    void deleteTrinitianoById(Long id);

    Trinitianos updateTrinitianoById(Long id, Trinitianos trinitianos);

}
