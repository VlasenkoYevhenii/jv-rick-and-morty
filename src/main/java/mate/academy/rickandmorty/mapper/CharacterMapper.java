package mate.academy.rickandmorty.mapper;

import mate.academy.rickandmorty.config.MapperConfig;
import mate.academy.rickandmorty.dto.CharacterDto;
import mate.academy.rickandmorty.dto.ExternalCharacterDto;
import mate.academy.rickandmorty.dto.ResponseDto;
import mate.academy.rickandmorty.model.Character;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(config = MapperConfig.class)
@Component
public interface CharacterMapper {
    public CharacterDto toDto(Character character);

    @Mapping(target = "externalId", source = "id")
    @Mapping(target = "id", ignore = true)
    Character toEntity(ExternalCharacterDto dto);

    ResponseDto toResponseDto(Character character);
}
