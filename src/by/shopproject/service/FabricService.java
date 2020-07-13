package by.shopproject.service;

import by.shopproject.dao.FabricDao;
import by.shopproject.dto.FabricDto;
import by.shopproject.entity.Fabric;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FabricService {

    private static final FabricService INSTANCE = new FabricService();


    public List<Fabric> getAll() {
        return FabricDao.getInstance().getAll();
    }

    public FabricDto save(FabricDto fabricDto) {
        Fabric fabric = FabricDao.getInstance().save(
                Fabric.builder()
                        .name(fabricDto.getName())
                        .country(fabricDto.getCountry())
                        .build()
        );
        return new FabricDto(fabric.getName(), fabric.getCountry());
    }

    public static FabricService getInstance() {
        return INSTANCE;
    }
}
