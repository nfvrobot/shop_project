package by.shopproject.service;

import by.shopproject.dao.GuitarDao;
import by.shopproject.dto.CreateNewGuitarDto;
import by.shopproject.dto.GuitarBuyDto;
import by.shopproject.dto.ViewGuitarBasicInfoDto;
import by.shopproject.dto.ViewGuitarFullInfoDto;
import by.shopproject.entity.Fabric;
import by.shopproject.entity.Guitar;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GuitarService {

    private static final GuitarService INSTANCE = new GuitarService();

    public List<ViewGuitarBasicInfoDto> getAll() {
        return GuitarDao.getInstance().getAll().stream()
                .map(it -> new ViewGuitarBasicInfoDto(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }

    public ViewGuitarFullInfoDto getById(Integer guitarId) {
        return GuitarDao.getInstance().getById(guitarId)
                .map(it -> ViewGuitarFullInfoDto.builder()
                        .fabricId(it.getFabric().getId())
                        .fabricName(it.getFabric().getName())
                        .fabricCountry(it.getFabric().getCountry())
                        .name(it.getName())
                        .strings(it.getStrings())
                        .colorName(it.getColor().getDescription())
                        .count(it.getCount())
                        .build())
                .orElse(null);
    }

    public ViewGuitarBasicInfoDto save(CreateNewGuitarDto dto) {
        Guitar saveGuitar = GuitarDao.getInstance().save(
                Guitar.builder()
                        .fabric(Fabric.builder().id(dto.getFabricId()).build())
                        .name(dto.getName())
                        .strings(dto.getStrings())
                        .color(dto.getColor())
                        .count(dto.getCount())
                        .build());

        return new ViewGuitarBasicInfoDto(saveGuitar.getId(), saveGuitar.getName());
    }

    public static GuitarService getInstance() {
        return INSTANCE;
    }
}

