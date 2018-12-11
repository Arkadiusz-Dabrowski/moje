package com.my.git.workapp.mapper;

import com.my.git.workapp.dto.AdvertisementDto;
import com.my.git.workapp.dto.EmployerDto;
import com.my.git.workapp.dto.EmployerWithAdvertsDto;
import com.my.git.workapp.model.Advertisement;
import com.my.git.workapp.model.Employer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployerMapper {

    EmployerDto toEmployerDto(Employer employer);

    abstract List<EmployerDto> toEmployerDto(Collection<Employer> employers);

    Employer toEmployerEntity(EmployerDto employerDto);
    Advertisement toAdvertisementEntity(AdvertisementDto advertisementDto);
    AdvertisementDto toAdvertisementDto(Advertisement advertisement);
    //List<AdvertisementDto> toAdvertisementDto(Collection<Advertisement> advertisement);
    //List<Advertisement> toAdvertisementEntity(Collection<AdvertisementDto> advertisementDto);

    @Mapping(target = "advertisementDtoList", source = "advertisements")
    EmployerWithAdvertsDto toEmplyerWithAdvertsDto(Employer employer);
}