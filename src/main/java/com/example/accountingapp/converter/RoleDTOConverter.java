package com.example.accountingapp.converter;

import com.example.accountingapp.dto.RoleDTO;
import com.example.accountingapp.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class RoleDTOConverter implements Converter<String, RoleDTO> {

    private final RoleService roleService;

    public RoleDTOConverter(@Lazy RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDTO convert(String source) {

        if (source == null || source.equals("")) {
            return null;
        }

        return roleService.findById(Long.parseLong(source));

    }

}

