package com.my.git.workapp.mapper;

import com.my.git.workapp.dto.AdvertisementDto;
import com.my.git.workapp.model.Advertisement;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AdvertisementMapper {


    AdvertisementDto toAdvertisementDto(Advertisement advertisement);
    List<AdvertisementDto> toAdvertisementDto(Collection<Advertisement> advertisements);

    Advertisement toAdvertisementEntity(AdvertisementDto advertisementDto);
    List<Advertisement> toAdvertisementEntity(Collection<AdvertisementDto> advertisementDtos);


}
