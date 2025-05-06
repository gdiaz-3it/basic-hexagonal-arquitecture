package com.service3it.mscv_tritianos.domain.ports.in;

import java.util.List;

import com.service3it.mscv_tritianos.domain.models.TritianosAplicaciones;

public interface FindAplicacionesById {

    List<TritianosAplicaciones> findAplicacionesById(Long id);

}
